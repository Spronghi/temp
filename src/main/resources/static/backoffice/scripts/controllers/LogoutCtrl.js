app.controller('LogoutCtrl', function ($scope, dataService, $window) {
    $scope.logout = function (){
        dataService.unset();
        $window.location.href = "/backoffice/login.html";
    }
});
