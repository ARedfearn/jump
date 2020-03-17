package jump.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;
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
  Maybe<Height> getHeight(@Body Planet planet) {
    return Maybe.just(planet)
      .flatMap(p -> jumpService.getHeight(p))
      .defaultIfEmpty(new Height());
  }
}
