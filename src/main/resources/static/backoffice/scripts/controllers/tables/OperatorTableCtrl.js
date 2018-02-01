app.controller('OperatorTableCtrl', function ($scope, $http) {
    $http.get("/user/operators/")
        .then(function (res) {
            $scope.operators = res.data;
        });
});
