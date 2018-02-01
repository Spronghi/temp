app.controller('PublicEvidenceCtrl', function ($window, $location, $scope, $http) {
    $scope.vm = [];
    $http.get("/user/evidence/"+$location.search().id)
        .then(function (res) {
            $scope.vm.evidence = res.data;
        });
    $http.get("/user/flags_by_evidence/"+$location.search().id)
        .then(function (res) {
            $scope.flags = res.data;
        });
    $scope.public = function(){
        var flagsConfig = {
            headers : {
                'Accept': 'text/plain'
            }
        }
        var flagsData = {
            id: $scope.flags.id,
            evidence: $scope.flags.evidence,
            owner: $scope.flags.owner,
            number: $scope.flags.number,
            domain: $scope.flags.domain,
            type: $scope.flags.type,
            material: $scope.flags.material,
            technique: $scope.flags.technique,
            culture: $scope.flags.culture,
            period: $scope.flags.period,
            value: $scope.flags.value,
            scaleOfDamage: $scope.flags.scaleOfDamage,
            original: $scope.flags.original,
            origin_place: $scope.flags.origin_place,
            storageLocation: $scope.flags.storageLocation,
            historicInformation: $scope.flags.historicInformation,
            description: $scope.flags.description,
            restauration: $scope.flags.restauration,
            author: $scope.flags.author,

            otherData: $scope.flags.otherData,
            weight: $scope.flags.weight,
            dimensions: $scope.flags.dimensions
        };

        $http.put('/user/flags', flagsData, flagsConfig).then(function (response) {
            $scope.putResultMessage = response.data;
        });
        
        
        var evidenceConfig = {
            headers : {
                'Accept': 'text/plain'
            }
        }
        var evidenceData = {
            id: $scope.vm.evidence.id,
            owner: $scope.vm.evidence.owner,
            operator: $scope.vm.evidence.operator,
            museum: $scope.vm.evidence.operator.museum,
            number: $scope.vm.evidence.number,
            domain: $scope.vm.evidence.domain,
            type: $scope.vm.evidence.type,
            title: $scope.vm.evidence.title,
            material: $scope.vm.evidence.material,
            technique: $scope.vm.evidence.technique,
            culture: $scope.vm.evidence.culture,
            period: $scope.vm.evidence.period,
            author: $scope.vm.evidence.author,
            dimensions: $scope.vm.evidence.dimensions,
            weight: $scope.vm.evidence.weight,
            value: $scope.vm.evidence.value,
            otherData: $scope.vm.evidence.otherData,
            origin_place: $scope.vm.evidence.origin_place,
            description: $scope.vm.evidence.description,
            restauration: $scope.vm.evidence.restauration,
            storageLocation: $scope.vm.evidence.storageLocation,
            historicInformation: $scope.vm.evidence.historicInformation,
            scaleOfDamage: $scope.vm.evidence.scaleOfDamage,
            original: $scope.vm.evidence.original,
            public: true
        };

        $http.put('/user/evidence', evidenceData, evidenceConfig).then(function (response) {
            $scope.putResultMessage = response.data;
        });
    }
});
