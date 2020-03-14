package jump.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/jump")
public class heightController {

  @Get(produces = MediaType.TEXT_PLAIN)

  public String index() {
    return "Hello World";
  }

}
