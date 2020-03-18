package jump.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.reactivex.Maybe;
import io.reactivex.Single;
import jump.service.JumpService;
import jump.model.Height;
import jump.domain.Planet;

@Controller()
public class HeightController {

  private JumpService jumpService;

  public HeightController(JumpService jumpService) {
    this.jumpService = jumpService;
  }

  @Get(value = "/jump")
  Maybe<Height> getHeight(@Body Maybe<Planet> planet) {
    return planet
      .flatMap(p -> jumpService.getHeight(p))
      .defaultIfEmpty(new Height());
  }

  @Put(value = "/planet")
  Single<Planet> putPlanet(@Body Planet planet) {
    return Single.just(planet);
  }
}
