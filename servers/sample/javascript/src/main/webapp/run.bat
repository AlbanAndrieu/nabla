cls

call setenv.bat

REM run selenium
REM webdriver-manager start

REM runs a simple HTTP server on localhost:1337 and autorefresh a page, when any file in project is changed
REM call grunt serve
REM runs unit tests in seperate browser window
REM call grunt karma:unit
REM runs e2e tests in seperate browser window ( see "Running tests" section below, for setting up envoirment).
call grunt protractor:e2e > protractor.log 2>&1
REM call protractor debug protractor-e2e.conf.js > protractor.log 2>&1
REM type c (continue)
REM compile less files into single style.css file
REM call grunt less

pause