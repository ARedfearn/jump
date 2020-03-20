# jump

Solar-Jump is a small REST API built using Micronaut to return the height(Meters) you can jump (assuming you jump 0.5 meters on Earth) on other planets.

The API uses an embedded H2 database which is created at runtime and destroyed once the application is stopped.

## Request

### PUT planet

    $ curl -i -H 'Content-Type:  application/json' -d '{"name" : "jupiter","gravity" : 24.79}' -X PUT  http://localhost:8080/planet
    
### Response

    HTTP/1.1 200 OK
    Date: Wed, 18 Mar 2020 11:59:48 GMT
    content-type: application/json
    content-length: 41
    connection: keep-alive

    {"id":1,"name":"jupiter","gravity":24.79}


## Request

### GET planet

    $ curl -i -X GET http://localhost:8080/planet
    
### Response

    HTTP/1.1 200 OK
    transfer-encoding: chunked
    Date: Wed, 18 Mar 2020 16:04:56 GMT
    transfer-encoding: chunked
    content-type: application/json

    [{"id":1,"name":"jupiter","gravity":24.79}]


## Request

### GET jump/planet

    $ curl -i -X GET  http://localhost:8080/jump/jupiter
    
### Response

    HTTP/1.1 200 OK
    Date: Wed, 18 Mar 2020 12:18:23 GMT
    content-type: application/json
    content-length: 14
    connection: keep-alive

    {"meters":0.2}
    


## Planets

    Planet	Gravity m/s²
    Earth 9.81
    Moon 3.03
    Mercury	3.7
    Jupiter	24.97
    Mars	3.71
    Saturn	10.44
    Uranus	8.87
    Neptune	11.15

