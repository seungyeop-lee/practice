(function() {
    var app = angular.module('todo', []);

    app.controller('TodoCtrl', ['$scope', function($scope) {
        $scope.todo = {
            title: '요가수행',
            completed: false,
            createdAt: Date.now()
        };
    }]);
})();