angular.
  module('shopping-cart').
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
        when('/checkOut', {
         template: '<check-out></check-out>'
        }).
        when('/thanksForPlaceingTheOrder', {
          template: '<order-message></order-message>'
        }).
        when('/viewOrders', {
          template: '<view-orders></view-orders>'
        }).  
          otherwise('/products');
    }
  ]);
