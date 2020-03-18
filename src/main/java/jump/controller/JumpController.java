package jump.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;
import jump.domain.Planet;
import jump.model.Height;
import jump.service.JumpService;

@Controller("/jump")
public class JumpController {

  private JumpService jumpService;

  public JumpController(JumpService jumpService) {
    this.jumpService = jumpService;
  }

  @Get()
  Maybe<Height> getHeight(@Body Maybe<Planet> planet) {
    return planet
      .flatMap(p -> jumpService.getHeight(p))
      .defaultIfEmpty(new Height());
  }
}
