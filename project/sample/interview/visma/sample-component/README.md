Sample component.
=============

## Installation

Install NPM modules.

```js
sudo npm install.
```

Install Javascript dependencies.

```js
bower install
```

Include module in your app.

```js
var myApp = angular.module('myApp', [
  'sample-component'
]);
```

## Usage

```js
$filter('truncate')(string, length, breakOnWord)
```

### Options

#### string
Type: `String`
Default value: `undefined`

A string you want filter to truncate.

#### length
Type: `Integer`
Default value: `undefined`

A length of a string before the filter will start working.

#### breakOnWord
Type: `Boolean`
Default value: `undefined`

Defines whether filter should apply the truncate in the middle of the word.


## Tests
```
grunt karma:unit
```

## Build your own version

```
grunt build
```
