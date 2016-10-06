(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .controller('ProductController', ProductController);

  /** @ngInject */
  function ProductController($rootScope, ProductService, ShoppingCartService) {

    var vm = this;
    vm.products;

    vm.addProduct = function(idProduct){
        if($rootScope.currentCart){
          ShoppingCartService.addProductToCart(idProduct, $rootScope.currentCart.id).then(function(response){
            $rootScope.currentCart = angular.copy(response);
          });

        } else {
          ShoppingCartService.addProduct(idProduct).then(function(response){
            $rootScope.currentCart = angular.copy(response);
          });  
        }
        
    };

    ProductService.getProducts().then(function(response) {
          vm.products = angular.copy(response);
    });

    
  }
})();
