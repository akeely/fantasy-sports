angular.module('auctionPlayerServices', ['ngResource']).
    factory('AuctionPlayer', function($resource) {
      return $resource('/fantasy-auction-webapp/league/0/auctionPlayer/:playerId', {}, {
          query: {method:'GET', params:{playerId:''}, isArray:true}
        }
      );
    });