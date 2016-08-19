(function(){


    var app = angular.module('app',["ngRoute"])
        .config(function ($routeProvider) {
        $routeProvider
            .when("/main",{
                templateUrl: "app/register/register.html"
                ,controller: "RegisterController"
            }).otherwise({redirectTo:"/main"});
    });



}());
