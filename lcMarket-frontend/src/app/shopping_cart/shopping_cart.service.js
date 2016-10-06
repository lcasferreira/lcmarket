(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .service('ShoppingCartService', ShoppingCartService);

  /** @ngInject */
  function ShoppingCartService($http, $q) {
  
    this.addProduct = function(idProduct){
      var deferred = $q.defer();
      var url = 'http://localhost:8680/lcmarket/shoppingKarts/products/' + idProduct;
        $http.post(url)
      .then(function(response){
        deferred.resolve(response.data);
        return deferred.promise;
      },  function (response) {
        deferred.reject(response);
        return deferred.promise;
      });
      return deferred.promise;
    }

    this.addProductToCart = function(idProduct, idShoppingCart){
      var deferred = $q.defer();
      var url = 'http://localhost:8680/lcmarket/shoppingKarts/' + idShoppingCart + '/products/' + idProduct;
        $http.put(url)
      .then(function(response){
        deferred.resolve(response.data);
        return deferred.promise;
      },  function (response) {
        deferred.reject(response);
        return deferred.promise;
      });
      return deferred.promise;
    }

    this.removeProductFromCart = function(idProduct, idShoppingCart){
      var deferred = $q.defer();
      var url = 'http://localhost:8680/lcmarket/shoppingKarts/' + idShoppingCart + '/products/' + idProduct;
        $http.delete(url)
      .then(function(response){
        deferred.resolve(response.data);
        return deferred.promise;
      },  function (response) {
        deferred.reject(response);
        return deferred.promise;
      });
      return deferred.promise;
    }

    this.getShoppingCart = function(idShoppingCart){
      var deferred = $q.defer();
      var url = 'http://localhost:8680/lcmarket/shoppingKarts/' + idShoppingCart;
        $http.get(url)
      .then(function(response){
        deferred.resolve(response.data);
        return deferred.promise;
      },  function (response) {
        deferred.reject(response);
        return deferred.promise;
      });
      return deferred.promise;
    }

     this.getCurrentShoppingCart = function(){
      var deferred = $q.defer();
      var url = 'http://localhost:8680/lcmarket/shoppingKarts/current';
        $http.get(url)
      .then(function(response){
        deferred.resolve(response.data);
        return deferred.promise;
      },  function (response) {
        deferred.reject(response);
        return deferred.promise;
      });
      return deferred.promise;
    }    
  }
})();