package jump.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.reactivex.Maybe;
import io.reactivex.Single;
import jump.domain.Planet;
import jump.model.Height;
import jump.service.JumpService;

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
    return Single.just(planet)
      .flatMap(p -> jumpService.putPlanet(p));
  }
}
