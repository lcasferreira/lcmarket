(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .config(routeConfig);

  function routeConfig($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'app/products/products.html',
        controller: 'ProductController',
        controllerAs: 'ctrl'
      })
      .when('/shopping_cart/:id', {
        templateUrl: 'app/shopping_cart/shopping_cart.html',
        controller: 'ShoppingCartController',
        controllerAs: 'ctrl'
      })
      .otherwise({
        redirectTo: '/'
      });


  }

})();
