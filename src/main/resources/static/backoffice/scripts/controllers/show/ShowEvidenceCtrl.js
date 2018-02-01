app.controller('ShowEvidenceCtrl', function ($window, $location, $scope, $http) {
    $scope.vm = [];
    $scope.vm.qrcode = "https://chart.googleapis.com/chart?cht=qr&choe=UTF-8&chs=200x200&chl="+$location.search().id;
    $http.get("/user/evidence/"+$location.search().id)
        .then(function (res) {
            $scope.vm.evidence = res.data;
        });
    $scope.deleteRow = function(){
        
        $http.delete("/user/evidence/"+$location.search().id)
            .then(function (res) {
                $scope.deleteResultMessage = res.data;
            });
    }
    var showOperator = function(){
        $window.location.href = "/backoffice/show/show-operator?id="+$scope.vm.evidence.operator.id;
    }
    
});
