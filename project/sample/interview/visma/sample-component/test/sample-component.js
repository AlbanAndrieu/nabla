'use strict';

describe('Filter: filters', function() {

  // load the service's module
  beforeEach(module('sample-component'));

  var filters;

  // Initialize the service and a mock backend
  beforeEach(inject(function($injector, $filter) {
    filters = $filter;
  }));


  describe("truncate", function() {

    it('should do nothing if NaN provided', function() {
      var truncate = filters('truncate')(2005 / 12 / 12);
      expect(truncate).toBe(2005 / 12 / 12);
    });

    it('should return empty string if length of the string is 0', function() {
      var truncate = filters('truncate')(' ', 0, false);
      expect(truncate.length).toBe(0);
    });

    it('should return empty string if length of the string is negative number', function() {
      var truncate = filters('truncate')(' ', -100, false);
      expect(truncate.length).toBe(0);
    });

    it('should return empty string if empty string is provided', function() {
      var truncate = filters('truncate')('');
      expect(truncate).toBe('');
    });

    it('should truncate and not break words', function() {
      var truncate = filters('truncate')('Some random text to truncate',15, false);
      expect(truncate).toBe('Some random…');
    });

    it('should truncate and break words', function() {
      var truncate = filters('truncate')('Some random text to truncate',15, true);
      expect(truncate).toBe('Some random tex…');
    });

  });

});
