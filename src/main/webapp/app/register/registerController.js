(function () {

    angular.module('app')
        .controller('RegisterController', ['$scope',RegisterController]);

        function RegisterController($scope) {
            $scope.message = "Hello";
        }
})();
