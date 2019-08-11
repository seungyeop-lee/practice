var todoList = [
    { done : true, title : "AngularJS 독서"},
    { done : false, title : "AngularJS 공부하기"},
    { done : false, title : "개인 프로젝트 구성"},
];

var myApp = angular.module('myApp', []);

myApp.controller('todoCtrl', function($scope) {
    $scope.appName = "AngularJS TODO APP";
    $scope.todoList = todoList;
});