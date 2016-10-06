(function() {
	'use strict';
	angular
	.module('lcMarketFrontend', ['ngCookies', 'ngSanitize', 'ngMessages', 'ngResource', 'ngRoute', 'ngMaterial', 'ngMdIcons'])
	.controller('IndexController', IndexController);

	function IndexController($rootScope) {		
		$rootScope.currentCart;
	}
})();
