(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .service('ShoppingCartService', ShoppingCartService);

  /** @ngInject */
  function ShoppingCartService($http, $q) {
    
    this.addProduct = function(idProduct){
      var deferred = $q.defer();
      //var params = ConfigurationService.getAsUriParam(filter);
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


    //ScrapService.$inject = ['$http', '$q'];
    
  }
})();