module.exports = function(config) {
  config.set({
    // base path, that will be used to resolve files and exclude
    basePath: '',

    // testing framework to use (jasmine/mocha/qunit/...)
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
      'js/src/app.js',
      'js/src/**/*.js',
      'test/unit/**/*.js',
    ],

    preprocessors: {
      'views/**/*.html': ['html2js']
    },

    // list of files to exclude
    exclude: [],

    // web server port
    port: 8081,

    // level of logging
    // possible values: LOG_DISABLE || LOG_ERROR || LOG_WARN || LOG_INFO || LOG_DEBUG
    logLevel: config.LOG_INFO,

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

    // Continuous Integration mode
    // if true, it capture browsers, run tests and exit
    singleRun: true
  });
};
