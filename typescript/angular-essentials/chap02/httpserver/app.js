const http = require('http');

http.createServer((request, response) => {
    response.statusCode = 200;
    response.setHeader('Content-Type', 'text/plain');
    response.end('Hello World');
}).listen(3000);

console.log('Server running at http://localhost:3000/');
