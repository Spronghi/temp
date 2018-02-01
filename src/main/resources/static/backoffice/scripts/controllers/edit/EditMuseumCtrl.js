app.controller('EditMuseumCtrl', function (dataService, $location, $scope, $http, $window) {
    if(dataService.getCurrentOperator().admin){
        $scope.vm = [];
        $http.get("/user/museum/"+$location.search().id)
            .then(function (res) {
                $scope.museum = res.data;
            });
        $scope.edit = function (){
            var config = {
                headers : {
                    'Accept': 'text/plain'
                }
            }
            var data = {
                id: $scope.museum.id,
                location: $scope.museum.location,
                address: $scope.museum.address,
                postalNo: $scope.museum.postalNo,
                description: $scope.museum.description,
                name: $scope.museum.name,
                email: $scope.museum.email
            };

            $http.put('/user/museum', data, config).then(function (response) {
                $scope.putResultMessage = response.data;
            });
        }
    } else {
        $window.location.href = "/backoffice/error.html?error=Permission error";
    }
});
