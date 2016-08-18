(function(){


    var app = angular.module('app',["ngRoute"])
        .config(function ($routeProvider) {
        console.log("sadasdaa");
        $routeProvider
            .when("/main",{
                templateUrl: "app/register/register.html"
                ,controller: "RegisterController"
            }).otherwise({redirectTo:"/main"});
    });



}());
