#!/bin/bash
set -xv

#as root

npm install phantomjs -g

#http://yslow.org/phantomjs/

npm install yslow -g

#https://www.npmjs.com/package/grunt-yslow
#npm install --global phantomjs
npm install grunt-yslow --save-dev

grunt yslow
#http://yslow.org/yslow-phantomjs-3.1.8.zip
phantomjs yslow.js --info basic --format plain http://localhost:9090/
#jenkins
./node_modules/phantomjs/bin/phantomjs yslow.js --help
./node_modules/phantomjs/bin/phantomjs yslow.js -i grade -threshold "B" -f junit http://localhost:9090/ > target/surefire-reports/yslow.xml
./node_modules/phantomjs/bin/phantomjs yslow.js -i grade -threshold "B" -f tap http://localhost:9090/ > target/yslow.tap
#phantomjs yslow.js --info grade --format tap --threshold '{"yminify": 90}' example.com

#https://github.com/steveworkman/grunt-yslow-test
#npm install grunt-yslow-test --save-dev

npm install psi -g
psi http://localhost:9090/

#https://www.npmjs.com/package/grunt-pagespeed
npm install grunt-pagespeed --save-dev

grunt pagespeed

#http://www.webpagetest.org/
Your API key is: A.01ea5a02081b6d10415d7b0e7c844e73
export WPT_API_KEY="A.01ea5a02081b6d10415d7b0e7c844e73"
#https://github.com/marcelduran/webpagetest-api
npm install webpagetest -g

npm install grunt-wpt --save-dev

./node_modules/webpagetest/bin/webpagetest --help
./node_modules/webpagetest/bin/webpagetest test t.co --key $WPT_API_KEY --first --location Dulles:Chrome --poll --timeout 60 --specs tco-specs.json --reporter spec

npm install -g sitespeed.io

npm install grunt-gh-pages --save-dev

#phantomas
#https://github.com/stefanjudis/grunt-phantomas
npm install --global phantomas
npm install grunt-phantomas --save-dev

npm install grunt-sitespeedio --save-dev

#uncss
npm install -g generator-webapp-uncss
yo webapp-uncss

npm install grunt-uncss --save-dev

#phantomcss
sudo npm install -g phantomcss
sudo npm install -g resemble-cli
#run-resemble width=500 url=https://www.optimizely.com/ pages=about,contact,resources/sample-size-calculator/,resources/live-demo-webinar,customers,customers/customer-stories screensDir=mobile
sudo npm install -g gm
#sudo npm install -g casperjs
#deprecated npm install grunt-phantomcss-gitdiff --save-dev
npm install grunt-resemble-cli --save-dev
