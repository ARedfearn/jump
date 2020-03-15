package jump.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jump.model.Height;

import javax.inject.Inject;

@Controller("/jump")
public class HeightController {

  public ObjectMapper objectMapper;

  @Inject
  public HeightController(ObjectMapper objectMapper){
    this.objectMapper = objectMapper;
  }

  @Get(produces = MediaType.TEXT_PLAIN)

  public String index() throws JsonProcessingException {
    Height height = new Height();
    return objectMapper.writeValueAsString(height);
  }

}
