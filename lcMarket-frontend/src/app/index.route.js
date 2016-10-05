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
        controllerAs: 'product'
      })
      .otherwise({
        redirectTo: '/'
      });
  }

})();
