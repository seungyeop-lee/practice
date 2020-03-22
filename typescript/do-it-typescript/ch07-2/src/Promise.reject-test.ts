Promise.reject(new Error('에러 발생'))
    .catch((err) => console.log('error:', err.message))
