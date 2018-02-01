app.controller('EvidenceTableCtrl', function ($window, $scope, $http, dataService) {
    $http.get("/user/evidences_by_operator/"+dataService.getCurrentOperator().id)
        .then(function (res) {
            $scope.evidences = res.data;
        });
    var open = function(id){
        $window.location.href = "/backoffice/show/show-evidence?id="+id;
    };
});
