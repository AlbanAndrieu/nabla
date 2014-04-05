cls

call setenv.bat

REM call npm install -g grunt
REM call npm install -g grunt-cli
REM call npm install -g bower
REM call npm install -g protractor
REM call npm install -g karma
REM call npm install -g karma-junit-reporter
REM call npm install -g karma-ng-scenario
REM call npm install -g karma-ng-html2js-preprocessor
REM call npm install -g karma-coverage
REM call npm install -g karma-jasmine
REM call npm install -g phantomjs 
REM call npm install -g karma-phantomjs-launcher
REM call npm install -g selenium-webdriver

call npm install grunt > install.log 2>&1
call npm install grunt-cli >> install.log 2>&1
call npm install bower >> install.log 2>&1
call npm install protractor >> install.log 2>&1
call npm install karma >> install.log 2>&1
call npm install karma-junit-reporter >> install.log 2>&1
call npm install karma-ng-scenario >> install.log 2>&1
call npm install karma-ng-html2js-preprocessor >> install.log 2>&1
call npm install karma-coverage >> install.log 2>&1
call npm install karma-jasmine >> install.log 2>&1
call npm install phantomjs >> install.log 2>&1
call npm install karma-phantomjs-launcher >> install.log 2>&1
call npm install selenium-webdriver >> install.log 2>&1
call npm install load-grunt-tasks >> install.log 2>&1
call npm install time-grunt >> install.log 2>&1
call npm install grunt-karma >> install.log 2>&1
call npm install grunt-mkdir >> install.log 2>&1
call npm install grunt-contrib-uglify >> install.log 2>&1
call npm install grunt-contrib-watch >> install.log 2>&1
call npm install grunt-contrib-less >> install.log 2>&1
call npm install grunt-newer >> install.log 2>&1
call npm install grunt-ngmin >> install.log 2>&1
call npm install grunt-contrib-clean >> install.log 2>&1
call npm install grunt-protractor-runner >> install.log 2>&1
call npm install grunt-connect-pushstate >> install.log 2>&1
call npm install grunt-modernizr >> install.log 2>&1
call npm install grunt-spritesmith >> install.log 2>&1
call npm install grunt-bower-task >> install.log 2>&1
call npm install grunt-connect-pushstate >> install.log 2>&1
call npm install grunt-concurrent >> install.log 2>&1
call npm install grunt-contrib-concat >> install.log 2>&1
call npm install grunt-contrib-connect >> install.log 2>&1
call npm install grunt-bower-task >> install.log 2>&1

call bower install > bower.log 2>&1

pause