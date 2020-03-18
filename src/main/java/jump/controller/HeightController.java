package jump.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;
import jump.service.JumpService;
import jump.model.Height;
import jump.domain.Planet;

@Controller()
public class HeightController {

  private JumpService jumpService;

  public HeightController(JumpService jumpService) {
    this.jumpService = jumpService;
  }

  @Get(value = "/jump", consumes = MediaType.APPLICATION_JSON)
  Maybe<Height> getHeight(@Body Maybe<Planet> planet) {
    return planet
      .flatMap(p -> jumpService.getHeight(p))
      .defaultIfEmpty(new Height());
  }
}
