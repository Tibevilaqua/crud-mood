(function () {

    angular.module('app')
        .controller('RegisterController', ['$scope',RegisterController]);


        function RegisterController($scope) {
            console.log("kaksakakaka");
            $scope.message = "Hello";
        }
})();
