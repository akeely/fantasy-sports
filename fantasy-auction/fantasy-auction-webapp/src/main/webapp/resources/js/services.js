angular.module('auctionPlayerServices', ['ngResource']).
    factory('AuctionPlayer', function($resource) {
      return $resource('/league/1/auctionPlayer/:playerId', {playerId:'@playerId'}, {
          update: {method:'PUT'}
      });
    }).factory('LeagueTeam', function($resource) {
    	return $resource('/league/1/team/:teamId', {teamId:'@teamId'});
    }); 

angular.module('teamServices', ['ngResource']).
  factory('Team', function($resource) {
	return $resource('/team', {}, {
		query: {method:'GET', isArray:true}
	  }  
	);
  });

angular.module('availablePlayerServices', ['ngResource']).
factory('AvailablePlayer', function($resource) {
	return $resource('/league/1/auctionPlayer/availablePlayer', {}, {
		query: {method:'GET', isArray:true}
	  }  
	);
});