package jump.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;
import jump.domain.Planet;
import jump.model.Height;
import jump.service.JumpService;

import javax.validation.constraints.NotBlank;

@Controller("/jump")
public class JumpController {

  private JumpService jumpService;

  public JumpController(JumpService jumpService) {
    this.jumpService = jumpService;
  }

  @Get("/{planet}")
  Maybe<Height> getHeight(@NotBlank String planet) {
    Planet p = new Planet();
    p.setName(planet);

    return Maybe.just(p)
      .flatMap(obj -> jumpService.getHeight(obj))
      .defaultIfEmpty(new Height());
  }
}
