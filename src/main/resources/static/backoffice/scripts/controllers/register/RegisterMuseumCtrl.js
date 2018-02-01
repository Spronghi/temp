app.controller('RegisterMuseumCtrl', function (dataService, $location, $scope, $http, $window) {
    if(dataService.getCurrentOperator().admin){
        $scope.vm = [];
        $scope.register = function (){
            var config = {
                headers : {
                    'Accept': 'text/plain'
                }
            }
            var data = {
                location: $scope.vm.location,
                address: $scope.vm.address,
                postalNo: $scope.vm.postalNo,
                description: $scope.vm.description,
                name: $scope.vm.name,
                email: $scope.vm.email
            };

            $http.post('/user/museum', data, config).then(function (response) {
                $scope.postResultMessage = response.data;
                $window.location.href = "/backoffice/admin.html";
            }, function error(response) {
                $window.location.href = "/backoffice/error.html?error=Ops! An error Occurred";
            });
        }
    } else {
        $window.location.href = "/backoffice/error.html?error=Permission error";
    }
});
