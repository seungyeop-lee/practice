//directive로 설정 할 경우, html에서 태그로 사용 가능
angular.module('todo').directive('todoTitle', function() {
    return {
        template: '<h1>Todo 목록</h1>'
    };
});

//directive로 설정 할 경우, html에서 태그로 사용 가능
angular.module('todo').directive('todoItem', function() {
    return {
        // template에 넣을 html문이 길 경우, 따로 파일을 만들어서 연결하는 것도 가능
        // 현재는 Local에서 작업 중이라 CORS 정책 위반으로 적용되지 않음
        // templateUrl: 'todoItem.tpl.html'

        template: 
            `<div class="input-group">
                <span class="input-group-addon">
                    <input type="checkbox" ng-model="todo.completed">
                </span>
                <input type="text" class="form-control" ng-model="todo.title">
                <span class="input-group-btn">
                    <button class="btn btn-danger" type="button" ng-click="remove(todo)">삭제</button>
                </span>
            </div>
            <date>{{todo.createdAt | date:'yyyy-MM-dd HH:mm:ss'}}</date>`
    }
});