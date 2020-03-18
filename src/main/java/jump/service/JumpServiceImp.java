package jump.service;

import io.reactivex.Maybe;
import jump.repository.PlanetRepository;
import jump.util.CalculateJump;
import jump.model.Height;
import jump.domain.Planet;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JumpServiceImp implements JumpService {

  private CalculateJump calculateJump;
  private PlanetRepository planetRepository;

  @Inject
  public JumpServiceImp(CalculateJump calculateJump, PlanetRepository planetRepository) {
    this.calculateJump = calculateJump;
    this.planetRepository = planetRepository;
  }

  @Override
  public Maybe<Height> getHeight(Planet planet) {
    return planetRepository.findByName(planet.getName())
      .map(p -> calculateJump.calculate(p))
      .defaultIfEmpty(new Height());
  }
}
