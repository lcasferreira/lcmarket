(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log) {

    $log.debug('runBlock end');
  }

})();
