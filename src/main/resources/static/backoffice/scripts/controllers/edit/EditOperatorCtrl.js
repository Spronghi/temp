app.controller('EditOperatorCtrl', function (dataService, $location, $scope, $http, $window) {
    if(dataService.getCurrentOperator().admin){
        $scope.vm = [];
        $http.get("/user/museums")
            .then(function (res) {
                $scope.museums = res.data;
            });
        $scope.getMuseum = function(){
            $http.get("/user/museum/"+$scope.selectedMuseum.id)
                .then(function (res) {
                    $scope.operator.museum = res.data;
                });
        }
        $http.get("/user/operator/"+$location.search().id)
            .then(function (res) {
                $scope.operator = res.data;
            });
        $scope.edit = function (){
            var config = {
                headers : {
                    'Accept': 'text/plain'
                }
            }
            var data = {
                id: $scope.operator.id,
                username: $scope.operator.username,
                password: $scope.operator.password,
                name: $scope.operator.name,
                surname: $scope.operator.surname,
                email: $scope.operator.email,
                admin: $scope.operator.admin,
                museum: $scope.operator.museum
            };

            $http.put('/user/operator', data, config).then(function (response) {
                $scope.putResultMessage = response.data;
            });
        }
    } else {
        $window.location.href = "/backoffice/error.html?error=Permission error";
    }
});
