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
    alert(message + ": " + JSON.stringify(response));
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
   
	alert("Bidding " + newBid + " on player " + player.id + " by team " + $scope.teamId);
	/*player.bid = newBid;
	player.teamId = $scope.teamId;
	AuctionPlayer.update(player);
	*/
	$scope.bid(player, newBid);
  };
 
  $scope.bidCustom = function(player) {
   
	alert("Bidding " + this.bidAmount + " on player " + player.id + " by team " + $scope.teamId);
	$scope.bid(player, this.bidAmount);
  };
}

function TeamCtrl($scope, Team) {
	
	$scope.teams = Team.query();
}
