(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .config(config);

  /** @ngInject */
  function config($logProvider) {
    // Enable log
    $logProvider.debugEnabled(true);

  }

})();
