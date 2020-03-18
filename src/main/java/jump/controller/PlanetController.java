package jump.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.reactivex.Flowable;
import io.reactivex.Single;
import jump.domain.Planet;
import jump.service.JumpService;

@Controller("/planet")
public class PlanetController {

  private JumpService jumpService;

  public PlanetController(JumpService jumpService) {
    this.jumpService = jumpService;
  }

  @Get("/")
  Flowable<Planet> getAll() {
    return jumpService.getAllPlanets();
  }

  @Put("/")
  Single<Planet> putPlanet(@Body Planet planet) {
    return Single.just(planet)
      .flatMap(p -> jumpService.putPlanet(p));
  }


}
