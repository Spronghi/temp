app.controller('EditEvidenceCtrl', function (dataService, $location, $scope, $http, $window) {
    if(dataService.getCurrentOperator().admin){
        $scope.operator = dataService.getCurrentOperator();
        $http.get("/user/evidence/"+$location.search().id)
            .then(function (res) {
                $scope.evidence = res.data;
            });
        $scope.edit = function (){
            var config = {
                headers : {
                    'Accept': 'text/plain'
                }
            }
            var data = {
                id: $scope.evidence.id,
                owner: $scope.evidence.owner,
                operator: $scope.operator,
                museum: $scope.operator.museum,
                number: $scope.evidence.number,
                domain: $scope.evidence.domain,
                type: $scope.evidence.type,
                title: $scope.evidence.title,
                material: $scope.evidence.material,
                technique: $scope.evidence.technique,
                culture: $scope.evidence.culture,
                period: $scope.evidence.period,
                author: $scope.evidence.author,
                dimensions: $scope.evidence.dimensions,
                weight: $scope.evidence.weight,
                value: $scope.evidence.value,
                otherData: $scope.evidence.otherData,
                originPlace: $scope.evidence.originPlace,
                description: $scope.evidence.description,
                restauration: $scope.evidence.restauration,
                storageLocation: $scope.evidence.storageLocation,
                historicInformation: $scope.evidence.historicInformation,
                scaleOfDamage: $scope.evidence.scaleOfDamage,
                original: $scope.evidence.original
            };

            $http.put('/user/evidence', data, config).then(function (response) {
                $scope.putResultMessage = response.data;
            });
        }
    } else {
        $window.location.href = "/backoffice/error.html?error=Permission error";
    }
});
