//즉시 실행함수로 angular module을 실행
(function() {
    //todo 라는 모듈 생성
    var app = angular.module('todo', []);

    //모듈에 TodoCtrl라는 컨트롤러를 추가
    app.controller('TodoCtrl', ['$scope', function($scope) {
        $scope.name = 'Chris'
        $scope.todo = {
            title: '요가수련',
            completed: false,
            createdAt: Date.now()
        };
    }]);
})();