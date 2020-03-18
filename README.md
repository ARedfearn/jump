# jump

Solar-Jump is a small REST API built using Micronaut to return the height(Meters) you can jump on other planets.

The API uses an embedded H2 database which is created at runtime and destroyed once the application is sttoped.

## Request

### PUT jump/planet

    $ curl -i -H 'Content-Type:  application/json' -d '{"name" : "jupiter","gravity" : 24.79}' -X PUT  http://localhost:8080/planet
    
### Response

    HTTP/1.1 200 OK
    Date: Wed, 18 Mar 2020 11:59:48 GMT
    content-type: application/json
    content-length: 41
    connection: keep-alive

    {"id":1,"name":"jupiter","gravity":24.79}


## Request

### GET jump/height

    $ curl -i -H 'Content-Type:  application/json' -d '{"name" : "jupiter"}' -X GET  http://localhost:8080/planet
    
### Response

    HTTP/1.1 200 OK
    Date: Wed, 18 Mar 2020 12:18:23 GMT
    content-type: application/json
    content-length: 14
    connection: keep-alive

    {"meters":0.2}
