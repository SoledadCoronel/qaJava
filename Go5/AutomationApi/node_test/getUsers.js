var http = require('http');

http.get({
        host: 'www.google.com'
            }, function(response) {
        // Continuously update stream with data
        var body = '';
        response.on('data', function(d) {
            console.log('dsddsdsds');
            body += d;
        });
        response.on('end', function() {
            console.log('sasassssaa');

            // Data reception is done, do whatever with it!
            var parsed = JSON.parse(body);
            callback({
                email: parsed.email,
                password: parsed.pass
            });
        });
    });
});
