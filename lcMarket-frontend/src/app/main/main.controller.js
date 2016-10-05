(function() {
  'use strict';

  angular
    .module('lcMarketFrontend')
    .controller('MainController', MainController);

  /** @ngInject */
  function MainController($timeout, toastr) {
    var vm = this;

    m.awesomeThings = [];
    vm.classAnimation = '';
    vm.creationDate = 1475562205649;
    vm.showToastr = showToastr;

    activate();

    function activate() {
      getWebDevTec();
      $timeout(function() {
        vm.classAnimation = 'rubberBand';
      }, 4000);
    }
  }
})();
