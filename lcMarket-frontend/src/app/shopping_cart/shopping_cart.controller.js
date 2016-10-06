(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .controller('ShoppingCartController', ShoppingCartController);

  /** @ngInject */
  function ShoppingCartController($routeParams, ShoppingCartService) {

    var vm = this;

    vm.shoppingCart;
    vm.idShoppingCart = $routeParams.id;

    if(vm.idShoppingCart){
      ShoppingCartService.getShoppingCart(vm.idShoppingCart).then(function(response) {
          vm.shoppingCart = angular.copy(response);
      });  
    }

    vm.removeProduct = function(idProduct){
        ShoppingCartService.removeProductFromCart(idProduct, vm.idShoppingCart).then(function(response){
            vm.shoppingCart = angular.copy(response);
        }); 
    }
  }
})();
