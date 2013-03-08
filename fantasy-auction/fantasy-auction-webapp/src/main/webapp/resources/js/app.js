angular.module('auctionApp', ['auctionPlayerServices', 'teamServices']);

angular.module('fantasyApp', ['auctionPlayerServices', 'teamServices']).config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when('/teams', {templateUrl: 'views/teams.html',   controller: TeamCtrl}).
      when('/auction/league/:leagueId/team/:teamId', {templateUrl: 'views/auction.html', controller: AuctionCtrl}).
      otherwise({redirectTo: '/teams'});
}]);