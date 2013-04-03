angular.module('auctionApp', ['auctionPlayerServices', 'teamServices']);

angular.module('fantasyApp', ['auctionPlayerServices', 'teamServices', 'availablePlayerServices']).config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when('/teams', {templateUrl: 'views/teams.html',   controller: TeamCtrl}).
      when('/league/:leagueId/team/:teamId/auction', {templateUrl: 'views/auction.html', controller: AuctionCtrl}).
      when('/league/:leagueId/team/:teamId/available-players', {templateUrl: 'views/available-players.html', controller: AvailablePlayerCtrl}).
      otherwise({redirectTo: '/teams'});
}]);