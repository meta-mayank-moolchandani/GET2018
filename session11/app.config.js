angular.
  module('productApp').
  config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/products', {
          template: '<product-list></product-list>'
        }).
         when('/cart', {
          template: '<cart-list></cart-list>'
        }).
        when('/checkout', {
          template: '<check-out></check-out>'
        }).
        otherwise('/products');
    }
  ]);
