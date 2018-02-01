app.controller('ErrorCtrl', function ($location, $scope) {
    $scope.error = $location.search().error;
});
