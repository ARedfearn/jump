package jump.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;
import jump.Service.JumpService;
import jump.model.Height;
import jump.model.Planet;

@Controller("/jump")
public class HeightController {

  private JumpService jumpService;

  public HeightController(JumpService jumpService) {
    this.jumpService = jumpService;
  }

  @Get(produces = MediaType.APPLICATION_JSON)
  Single<MutableHttpResponse<Height>> echoFlow(@Body Single<Planet> planetSingle) {
    return planetSingle
      .flatMap(planet -> jumpService.getJumpHeight(planet))
      .map(HttpResponse::ok);
  }
}
