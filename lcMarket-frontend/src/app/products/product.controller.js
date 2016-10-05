(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .controller('ProductController', ProductController);

  /** @ngInject */
  function ProductController(ProductService) {
    var vm = this;

    vm.products;

    ProductService.getProducts().then(function(response) {
        vm.products = response;
    });
  }
})();
