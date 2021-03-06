package jump.service;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import jump.domain.Planet;
import jump.model.Height;
import jump.repository.PlanetRepository;
import jump.util.CalculateJump;

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

  @Override
  public Single<Planet> putPlanet(Planet planet) {
    return planetRepository.save(planet);
  }

  @Override
  public Flowable<Planet> getAllPlanets() {
    return planetRepository.findAll();
  }


}
