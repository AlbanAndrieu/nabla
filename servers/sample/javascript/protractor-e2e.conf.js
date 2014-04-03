// A reference configuration file.
exports.config = {
  // The address of a running selenium server.
  seleniumAddress: 'http://localhost:4444/wd/hub',

  allScriptsTimeout: 10000000,

  // ----- What tests to run -----
  //
  // Spec patterns are relative to the location of this config.
  // For example: 'spec/*_spec.js',
  specs: [
    'test/e2e/login.js',
    'test/e2e/greetingScreen.js',
    'test/e2e/searchFilter.js',
    'test/e2e/formScreen.js'
  ],

  // ----- Capabilities to be passed to the webdriver instance ----
  //
  // For a full list of available capabilities, see
  // https://code.google.com/p/selenium/wiki/DesiredCapabilities
  // and
  // https://code.google.com/p/selenium/source/browse/javascript/webdriver/capabilities.js
    
  capabilities: {
    'browserName': 'chrome',
  },

  onPrepare: function() {
    // The require statement must be down here, since jasmine-reporters
    // needs jasmine to be in the global and protractor does not guarantee
    // this until inside the onPrepare function.
    require('jasmine-reporters');
    jasmine.getEnv().addReporter(
      new jasmine.JUnitXmlReporter('target/jasmine-reports', true, true));
  },

  multiCapabilities: [
  {'browserName': 'chrome'},
  // {'browserName': 'firefox'}
  // //{'browserName': 'safari'}
  // //{'browserName': 'internet explorer'}
  ],

  //   capabilities: {
  //   browserName: 'firefox',
  //   version: '',
  //   platform: 'ANY'
  // },

  // A base URL for your application under test. Calls to protractor.get()
  // with relative paths will be prepended with this.
  baseUrl: 'http://127.0.0.1:1337',

  // Selector for the element housing the angular app - this defaults to
  // body, but is necessary if ng-app is on a descendant of <body>
  rootElement: 'body',

  // ----- Options to be passed to minijasminenode -----
  jasmineNodeOpts: {
    // onComplete will be called just before the driver quits.
    onComplete: null,
    // If true, display spec names.
    isVerbose: true,
    // If true, print colors to the terminal.
    showColors: true,
    // If true, include stack traces in failures.
    includeStackTrace: false,
    // Default time to wait in ms before a test fails.
    defaultTimeoutInterval: 100000000
  }
};
