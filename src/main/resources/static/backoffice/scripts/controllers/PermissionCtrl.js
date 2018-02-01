app.controller('PermissionCtrl', function (dataService, $location, $scope, $http, $window) {
    if(dataService.getCurrentId()==0){
        $window.location.href = "/backoffice/error.html?error=Permission error";
    }
});
