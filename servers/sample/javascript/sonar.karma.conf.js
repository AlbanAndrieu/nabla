module.exports = function(config) {
    config.set({
      // base path, that will be used to resolve files and exclude
      basePath: '',

      // frameworks to use
      frameworks: ['jasmine'],

      // list of files / patterns to load in the browser
      files: [
        'libs/angular/angular.js',
        'libs/angular-bootstrap/ui-bootstrap-tpls.min.js',
        'libs/angular-mocks/angular-mocks.js',
        'libs/angular-route/angular-route.js',
        'libs/angular-cookie/angular-cookie.js',
        'libs/angular-sanitize/angular-sanitize.js',
        'libs/lodash/dist/lodash.js',
        'modules/*/*.js',
        'views/**/*.html',
        'js/src/**/*.js',
        'test/unit/**/*.js',
      ],

      preprocessors: {
        'views/**/*.html': ['html2js'],
        'js/**/**/*.js': ['coverage']
      },

      // list of files to exclude
      exclude: [],

      // test results reporter to use
      // possible values: 'dots', 'progress', 'junit', 'growl', 'coverage'
      reporters: ['progress', 'coverage', 'junit'],

      coverageReporter: {
        type: 'lcovonly',
        dir: 'karma-coverage'
      },

      junitReporter: {
        outputFile: 'TEST-Karma-resultsTest.xml'
      },

      // web server port
      port: 9876,

      // enable / disable colors in the output (reporters and logs)
      colors: true,

      // level of logging
      // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
      logLevel: config.LOG_DEBUG,

      // enable / disable watching file and executing tests whenever any file changes
      autoWatch: true,

      // Start these browsers, currently available:
      // - Chrome
      // - ChromeCanary
      // - Firefox
      // - Opera
      // - Safari (only Mac)
      // - PhantomJS
      // - IE (only Windows)
      browsers: ['PhantomJS'],

      // If browser does not capture in given timeout [ms], kill it
      captureTimeout: 60000,

      // Continuous Integration mode
      // if true, it capture browsers, run tests and exit
      singleRun: true
    });
};
