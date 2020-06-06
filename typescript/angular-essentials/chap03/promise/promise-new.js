function get(url) {
    return new Promise(((resolve, reject) => {
        const xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                resolve(xhr.response);
            } else {
                reject('Error: ' + xhr.status);
            }
        }

        xhr.open('GET', url);
        xhr.send();
    }))
}
