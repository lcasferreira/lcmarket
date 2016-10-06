(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .service('ProductService', ProductService);

  /** @ngInject */
  function ProductService($http, $q) {
    
    this.getProducts = function(){
      var deferred = $q.defer();
      //var params = ConfigurationService.getAsUriParam(filter);
      var url = 'http://localhost:8680/lcmarket/products';
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


    //ScrapService.$inject = ['$http', '$q'];
    
  }
})();