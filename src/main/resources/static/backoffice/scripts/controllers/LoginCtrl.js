app.controller('LoginCtrl', function ($scope, dataService, $http, $window) {
    if(dataService.getCurrentId() == 0 || typeof dataService.getCurrentOperator() == "undefined"){
        //do nothing
    } else if(dataService.getCurrentOperator().admin){
        if($window.location != "/backoffice/admin.html"){
           $window.location.href = "/backoffice/admin.html";
        }
    } else if(!dataService.getCurrentOperator().admin){
        if($window.location != "/backoffice/index.html"){
           $window.location.href = "/backoffice/index.html";
        }
        
    }
    $scope.currentOperator = [];
    $scope.login = function () {
        $http.get("/user/login/"+$scope.vm.username)
            .then(function (res) {
                $scope.currentOperator = res.data;
                if($scope.currentOperator.username == $scope.vm.username){
                    dataService.set($scope.currentOperator);
                    if($scope.currentOperator.admin){
                        $window.location.href = "/backoffice/admin.html";
                    } else {
                        $window.location.href = "/backoffice/index.html";
                    }
                } else {
                    $scope.userLabel = "Invalid username or password";
                }
            });
        }
    });
