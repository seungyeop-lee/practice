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
        }
    }

    return storage;
});