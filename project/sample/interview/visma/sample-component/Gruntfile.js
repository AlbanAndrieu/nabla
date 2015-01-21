'use strict';

module.exports = function(grunt) {

  require('load-grunt-tasks')(grunt);

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),

    bower: {
      install: {
        options: {
          targetDir: 'bower_components',
          install: true,
          verbose: true,
          cleanTargetDir: true,
          cleanBowerDir: false,
          bowerOptions: {},
          copy: true
        }
      }
    },

    uglify: {
      build: {
        files: {
          'build/sample-component.min.js': ['src/sample-component.js']
        }
      }
    },

    copy: {
      main: {
        files: [{
          expand: true,
          cwd: 'src/',
          src: 'sample-component.js',
          dest: 'build/'
        }]
      }
    },

    clean: ['build/sample-component.js', '.bower-cache', '.bower-registry', '.bower-tmp'],

    karma: {
      unit: {
        configFile: 'karma.conf.js'
      }
    },

  });

  grunt.registerTask('default', function() {
    grunt.task.run([

    ]);
  });
  
  grunt.registerTask('build', function() {
    grunt.task.run([
      'clean',    
      'bower:install',
      'uglify', 
      'copy', 
      'karma:unit',
    ]);
  });

};
