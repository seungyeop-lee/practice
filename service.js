angular.module('todo').factory('todoStorage', function() {
    var TODO_DATA = 'TODO_DATA';
    var storage = {
        todos: [],

        _saveToLocalStorage: function(data) {
            localStorage.setItem(TODO_DATA, JSON.stringify(data));
        },

        _getFromLocalStorage: function() {
            return JSON.parse(localStorage.getItem(TODO_DATA)) || [];
        },

        get: function() {
            angular.copy(this._getFromLocalStorage(), this.todos);
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
                this._saveToLocalStorage(this.todos);
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

            this._saveToLocalStorage(this.todos);
        }
    }

    return storage;
});