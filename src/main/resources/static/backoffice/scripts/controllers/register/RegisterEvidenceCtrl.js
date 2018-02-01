app.controller('RegisterEvidenceCtrl', function (dataService, $location, $scope, $http, $window) {
    $scope.vm = [];
    $scope.register = function (){
        var config = {
            headers : {
                'Accept': 'text/plain'
            }
        }
        var data = {
            owner: $scope.vm.owner,
            operator: dataService.getCurrentOperator(),
            museum: dataService.getCurrentOperator().museum,
            number: $scope.vm.number,
            domain: $scope.vm.domain,
            type: $scope.vm.type,
            title: $scope.vm.title,
            material: $scope.vm.material,
            technique: $scope.vm.technique,
            culture: $scope.vm.culture,
            period: $scope.vm.period,
            author: $scope.vm.author,
            originPlace: $scope.vm.originPlace,
            dimensions: $scope.vm.dimensions,
            weight: $scope.vm.weight,
            value: $scope.vm.value,
            otherData: $scope.vm.otherData,
            description: $scope.vm.description,
            restauration: $scope.vm.restauration,
            storageLocation: $scope.vm.storageLocation,
            historicInformation: $scope.vm.historicInformation,
            scaleOfDamage: $scope.vm.scaleOfDamage,
            original: $scope.vm.original
        };

        $http.post('/user/evidence', data, config).then(function (response) {
            $scope.postResultMessage = response.data;
            if(dataService.getCurrentOperator().admin){
                $window.location.href = "/backoffice/admin.html";
            } else {
                $window.location.href = "/backoffice/index.html";
            }
        }, function error(response) {
            $window.location.href = "/backoffice/error.html?error=Ops! An error Occurred";
        });
    }
});
