package jump.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import javax.inject.Inject;

@Controller("/jump")
public class HeightController {

  public ObjectMapper objectMapper;

  @Inject
  public HeightController(ObjectMapper objectMapper){
    this.objectMapper = objectMapper;
  }

  @Get(produces = MediaType.APPLICATION_JSON)
  Single<MutableHttpResponse<String>> echoFlow(@Body Single<String> body) {
    return body.map(HttpResponse::ok);
  }

}
