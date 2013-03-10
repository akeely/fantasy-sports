angular.module('auctionPlayerServices', ['ngResource']).
    factory('AuctionPlayer', function($resource) {
      return $resource('/league/1/auctionPlayer/:playerId', {playerId:'@playerId'}, {
          update: {method:'PUT'}
      });
    }); 

angular.module('teamServices', ['ngResource']).
  factory('Team', function($resource) {
	return $resource('/team', {}, {
		query: {method:'GET', isArray:true}
	  }  
	);
  });