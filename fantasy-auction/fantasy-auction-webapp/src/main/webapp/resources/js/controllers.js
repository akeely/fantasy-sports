function AuctionCtrl($scope, $http, AuctionPlayer) {
  $scope.auctionPlayers = [
    {text:'learn angular', done:true},
    {text:'build an angular app', done:false}];
 
  $scope.players = AuctionPlayer.query();
  /*$http.get('players.json').success(
    function(data) {
      $scope.players = data;
    }
  );*/
 
 
  $scope.bid = function(player) {
  
    player.bid = $scope.bidAmount;
    
  };
 
  $scope.addTodo = function() {
    $scope.auctionPlayers.push({text:$scope.todoText, done:false});
    $scope.todoText = '';
  };
 
  $scope.remaining = function() {
    var count = 0;
    angular.forEach($scope.auctionPlayers, function(auctionPlayer) {
      count += auctionPlayer.done ? 0 : 1;
    });
    return count;
  };
 
  $scope.archive = function() {
    var oldPlayers = $scope.auctionPlayers;
    $scope.auctionPlayers = [];
    angular.forEach(oldPlayers, function(player) {
      if (!player.done) $scope.auctionPlayers.push(player);
    });
  };
}
