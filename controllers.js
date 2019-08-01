angular.module('todo').controller('TodoCtrl', function($scope, todoStorage) {

    $scope.todos = todoStorage.get();

    $scope.remove = function(todo) {
        // todos에 있는 todo(item)과 클릭된 부분의 todo(todo) 중 같은 부분의 index저장
        var idx = $scope.todos.findIndex(function(item) {
            return item == todo;
        });

        // 해당하는 todo가 있을 경우 삭제
        if(idx > -1) {
            $scope.todos.splice(idx, 1);
        }
    };

    $scope.add = function(newTodoTitle) {
        // 새로운 todo를 생성
        var newTodo = {
            title: newTodoTitle,
            completed: false,
            createdAt: Date.now()
        };

        // todos에 추가
        $scope.todos.push(newTodo);

        // input태그 비워 줌
        $scope.newTodoTitle = "";
    };
});