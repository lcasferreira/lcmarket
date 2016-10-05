(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .service('ProductService', ProductService);

  /** @ngInject */
  function ProductService($http) {
    
    this.getProducts = function(){
      var deferred = $q.defer();
      var params = ConfigurationService.getAsUriParam(filter);
      var url = ConfigurationService.getServiceHost() + '/shopfloor/management/production/scrap' + params;
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


    //ScrapService.$inject = ['$http', '$q', 'ConfigurationService'];
    
  }
})();