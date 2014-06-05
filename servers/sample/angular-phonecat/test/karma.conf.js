module.exports = function(config){
  config.set({

    basePath : '../',

    files : [
      'app/bower_components/angular/angular.js',
      'app/bower_components/angular-route/angular-route.js',
      'app/bower_components/angular-resource/angular-resource.js',
      'app/bower_components/angular-animate/angular-animate.js',
      'app/bower_components/angular-mocks/angular-mocks.js',
      'app/js/**/*.js',
      'test/unit/**/*.js'
    ],

    frameworks: ['jasmine'],

    plugins : [
            'karma-chrome-launcher',
            'karma-firefox-launcher',
            'karma-phantomjs-launcher',
            'karma-ie-launcher',
            'karma-junit-reporter',
            'karma-coverage',
            'karma-jasmine',
            'karma-requirejs'
            ],

	// test results reporter to use
	// possible values: dots || progress || growl
	reporters: ['dots', 'progress', 'junit', 'coverage'],

	// web server port
	port: 8080,

	// cli runner port
	runnerPort: 9100,

	// enable / disable colors in the output (reporters and logs)
	colors: true,

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
    
	// If browser does not capture in given timeout [ms], kill it
	captureTimeout: 5000,

	// Continuous Integration mode
	// if true, it capture browsers, run tests and exit
	singleRun: true,
	
    junitReporter: {
      outputFile: 'target/surefire-reports/TEST-karma.xml',
      suite: 'unit'
    },

	preprocessors: {
      // source files, that you wanna generate coverage for
      // do not include tests or libraries
      'app/*.html': ['html2js'],			      
      // (these files will be instrumented by Istanbul)
      'app/js/*.js': ['coverage']
    },
	
	// optionally, configure the reporter
	//coverageReporter: {
	//	type : 'html',
	//	dir : 'coverage/'
	//}            
	coverageReporter: {
		type: 'lcov',
		dir: 'target/karma-coverage'
	}			
  });
};
