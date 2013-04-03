function AuctionCtrl($scope, $routeParams, $timeout, AuctionPlayer, LeagueTeam) {

	$scope.leagueId = $routeParams.leagueId;
	$scope.teamId = $routeParams.teamId;

	$scope.players = AuctionPlayer.query();
	$scope.teams = LeagueTeam.query();
	
	function updatePlayers() {
		var updatedPlayers = AuctionPlayer.query([],
				function() {
			$scope.players = updatedPlayers;
		},
		function(response) {
			$scope.handleErrorResponse(response, "Failed to refresh player list");
		}  
		);
	};

	(function autoRefresh() {
		if($routeParams.refresh === "true") {
			$timeout(autoRefresh,3000);
			updatePlayers();
		}
	}());

	$scope.handleErrorResponse = function(response, message) {
		alert(message + ": " + response.data);
	};

	$scope.bid = function(player,amount) {
		player.bid=amount;
		AuctionPlayer.update(player, 
				updatePlayers,
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
	
	$scope.budget = function(team) {
		// TODO: Get this from the league.
		var money = 250;
		
		var playersWon = team.playersWon;
		for(var i=0; i < playersWon.length; i++) {
			money -= playersWon[i].cost;
		}
		
		return money;
	};
}

function TeamCtrl($scope, Team) {

	$scope.teams = Team.query();
}

function AvailablePlayerCtrl($scope, $routeParams, AvailablePlayer, AuctionPlayer, LeagueTeam) {
	
	$scope.availablePlayers = AvailablePlayer.query();
	var teams = LeagueTeam.query();
	for (t in teams) {
		if(t.teamId === $routeParams.teamId) {
			$scope.team = t;
		}
	}
	
	
	
}

