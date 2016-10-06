(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .controller('ProductController', ProductController);

  /** @ngInject */
  function ProductController($rootScope, $mdToast, ProductService, ShoppingCartService) {

    var vm = this;
    vm.products;
    vm.currentCart;

    vm.addProduct = function(idProduct){
        if($rootScope.currentCart){
          ShoppingCartService.addProductToCart(idProduct, $rootScope.currentCart.id).then(function(response){
            vm.currentCart = angular.copy(response);
            $rootScope.idCurrentCart = vm.currentCart.id;
            vm.showSuccessMsg();
          });

        } else {
          ShoppingCartService.addProduct(idProduct).then(function(response){
            vm.currentCart = angular.copy(response);
            $rootScope.idCurrentCart = vm.currentCart.id;
            vm.showSuccessMsg();
          });  
        }
        
    };

    ProductService.getProducts().then(function(response) {
          vm.products = angular.copy(response);
    });

    vm.showSuccessMsg = function(){
      $mdToast.show(
        $mdToast.simple()
          .textContent('Produto adicionado ao carrinho')
          .hideDelay(3000)
      );
    };

    
  }
})();
