function AuctionCtrl($scope, $routeParams, AuctionPlayer) {
	
  $scope.leagueId = $routeParams.leagueId;
  $scope.teamId = $routeParams.teamId;
 
  $scope.players = AuctionPlayer.query();
  /*$http.get('players.json').success(
    function(data) {
      $scope.players = data;
    }
  );*/
 
  $scope.handleErrorResponse = function(response, message) {
    alert(message + ": " + response.data);
  };
 
  $scope.bid = function(player,amount) {
    player.bid=amount;
    AuctionPlayer.update(player, 
      function(){
        var updatedPlayers = AuctionPlayer.query([],
          function() {
            $scope.players = updatedPlayers;
          },
          function(response) {
            $scope.handleErrorResponse(response, "Failed to refresh player list");
          }
        );	
      },
      function(response) {
        $scope.handleErrorResponse(response, "Bid failed");
      }
    );
  };
   
  $scope.bidMin = function(player) {
   
    var newBid = player.bid + 1;
   
	$scope.bid(player, newBid);
  };
 
  $scope.bidCustom = function(player) {
   
	$scope.bid(player, this.bidAmount);
  };
}

function TeamCtrl($scope, Team) {
	
	$scope.teams = Team.query();
}
