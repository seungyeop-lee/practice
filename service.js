angular.module('todo').factory('todoStorage', function() {
    var storage = {
        todos: [
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
        ],

        get: function() {
            return this.todos;
        },

        remove: function(todo) {
            // todos에 있는 todo(item)과 클릭된 부분의 todo(todo) 중 같은 부분의 index저장
            var idx = this.todos.findIndex(function(item) {
                return item == todo;
            });

            // 해당하는 todo가 있을 경우 삭제
            if(idx > -1) {
                this.todos.splice(idx, 1);
            }
        },
        
        add: function(newTodoTitle) {
            // 새로운 todo를 생성
            var newTodo = {
                title: newTodoTitle,
                completed: false,
                createdAt: Date.now()
            };

            // todos에 추가
            this.todos.push(newTodo);
        }
    }

    return storage;
});