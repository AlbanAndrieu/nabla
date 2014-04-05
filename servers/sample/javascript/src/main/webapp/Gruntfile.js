'use strict';

module.exports = function (grunt) {

  // Load grunt tasks automatically
  require('load-grunt-tasks')(grunt);

  // Time how long tasks take. Can help when optimizing build times
  require('time-grunt')(grunt);

  var pushState = require('grunt-connect-pushstate/lib/utils').pushState;

  // Define the configuration for all the tasks
  grunt.initConfig({

    sprite:{
      all: {
        src: 'img/*.png',
        destImg: 'img/spritesheet.png',
        destCSS: 'styles/less/sprites.less',
        cssFormat: 'less',
        engine: 'phantomjs'
      }
    },

    bower: {
      install: {
        targetDir: 'libs',
        cleanBowerDir: true,
        cleanup: true
      }
    },

    clean: ['lib'],

    // Watches files for changes and runs tasks based on the changed files
    watch: {
      styles: {
        files: ['styles/less/*.less', 'styles/less/*/*.less'],
        tasks: ['less'],
        options: {
          livereload: true,
        },
      },
      directives: {
        files: ['js/src/directives/*.js', 'js/src/directives/*/*.js'],
        tasks: ['concat:directives'],
        options: {
          livereload: true,
        }
      },
      services: {
        files: ['js/src/services/*.js'],
        tasks: ['concat:services'],
        options: {
          livereload: true,
        }
      },
      controllers: {
        files: ['js/src/controllers/*.js'],
        tasks: ['concat:controllers'],
        options: {
          livereload: true,
        }
      },
      filters: {
        files: ['js/src/filters/*.js'],
        tasks: ['concat:filters'],
        options: {
          livereload: true,
        }
      },
      modules: {
        files: ['modules/*/*.js'],
        tasks: ['concat:modules'],
        options: {
          livereload: true,
        }
      },
      html: {
        files: ['*.html', 'views/*/*.html','views/*.html'],
        options: {
          livereload: true,
        }
      },
      // TODO: uncomment, when ready !
      // sprites: {
      //   files: ['img/*.png'],
      //   tasks: ['sprite'],
      //   options: {
      //     livereload: true,
      //   }
      // },
    },

    // The actual grunt server settings
    connect: {
        options: {
          port: 1337,
          hostname: 'localhost',
          livereload: 35729,
          middleware: function (connect, options) {
            return [
              // Rewrite requests to root so they may be handled by router
              pushState(),
              connect.static(options.base)
            ];
          },
        },
        livereload: {
            options: {
              open: true,
              base: '.'
            }
          }
        },
        less: {
          development: {
            options: {
              compress: true,
              paths: ['styles/less/*/']
            },
            files: {
              'styles/css/style.css': 'styles/less/style.less',
              'styles/css/modules.css': 'modules/*/*.less'
            }
          }
        },

      concat: {
        options: {
          separator: ';',
        },
        libs: {
          src: [
            'libs/lodash/dist/lodash.compat.min.js',
            'libs/modernizr/modernizr-custom.js',
            'libs/angular/angular.min.js',
            'libs/angular-animate/*.min.js',
            'libs/angular-route/*.min.js',
            'libs/angular-cookie/*.min.js',
            'libs/angular-bootstrap/*-tpls.min.js',
            'libs/angular-sanitize/*.min.js'
          ],
          dest: 'js/build/libs.js'
        },
        directives: {
          src: ['js/src/directives/*.js', 'js/src/directives/*/*.js'],
          dest: 'js/build/directives.js'
        },
        controllers: {
          src: ['js/src/controllers/*.js', 'js/src/controllers/*/*.js'],
          dest: 'js/build/controllers.js'
        },
        services: {
          src: ['js/src/services/*.js', 'js/src/services/*/*.js'],
          dest: 'js/build/services.js'
        },
        filters: {
          src: ['js/src/filters/*.js', 'js/src/filters/*/*.js'],
          dest: 'js/build/filters.js'
        },
        modules: {
          src: ['modules/*/*.js'],
          dest: 'js/build/modules.js'
        }
      },

      // TODO: implement this before uglify
      ngmin: {
        src: ['js/src/app.js'],
        dest: 'js/build/app.min.js'
      },

      // Test settings
      karma: {
        unit: {
          configFile: 'karma.conf.js',
          singleRun: false
        }
      },

      protractor: {
          e2e: {
            options: {
              configFile: 'protractor-e2e.conf.js',
              args: {}
            }
          },
          jenkins_e2e: {
            options: {
              configFile: 'protractor-jenkins-e2e.conf.js',
              args: {}
            }
          },
        },

        modernizr: {
          'devFile' : 'libs/modernizr/modernizr.js',
          'outputFile' : 'libs/modernizr/modernizr-custom.js',
          'uglify': true
        },
        mkdir: {
          all: {
            options: {
              create: ['js/build']
            },
          },
        },
    });

grunt.registerTask('img', ['glue']);

grunt.registerTask('default', function () {
  grunt.task.run([
    'mkdir',
    'bower:install',
    'clean',
    'concat:libs',
    'concat:directives',
    'concat:controllers',
    'concat:services',
    'concat:filters',
    'concat:modules',
    'less',
    ]);
});

grunt.registerTask('serve', function () {
  grunt.task.run([
    'mkdir',
    'bower:install',
    'clean',
    'concat:libs',
    'concat:directives',
    'concat:controllers',
    'concat:services',
    'concat:filters',
    'concat:modules',
    'less',
    'connect:livereload',
    'watch',
    ]);
});

};
