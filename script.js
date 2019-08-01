(function() {
    var app = angular.module('todo', []);

    app.controller('TodoCtrl', ['$scope', function($scope) {
        $scope.todos = [
            {
                title: '요가수행',
                completed: false,
                createdAt: Date.now()
            },
            {
                title: '앵귤러 학습',
                completed: false,
                createdAt: Date.now()
            },
            {
                title: '운동하기',
                completed: true,
                createdAt: Date.now()
            }
        ];
    }]);
})();