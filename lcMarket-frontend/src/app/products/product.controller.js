(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .controller('ProductController', ProductController);

  /** @ngInject */
  function ProductController(ProductService, ShoppingCartService) {

    var vm = this;

    vm.currentCart;
    vm.products;

    vm.addProduct = function(idProduct){
        ShoppingCartService.addProduct(idProduct).then(function(response){
          vm.currentCart = angular.copy(response);
        });
    };

    ProductService.getProducts().then(function(response) {
          vm.products = angular.copy(response);
    });

    
  }
})();
