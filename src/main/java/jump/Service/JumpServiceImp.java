package jump.Service;

import io.reactivex.Maybe;
import jump.Repository.JumpRepository;
import jump.Util.CalculateJump;
import jump.model.Height;
import jump.model.Planet;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JumpServiceImp implements JumpService {

  private JumpRepository repository;
  private CalculateJump calculateJump;

  @Inject
  public JumpServiceImp(CalculateJump calculateJump, JumpRepository jumpRepository) {
    this.calculateJump = calculateJump;
    this.repository = jumpRepository;
  }


  @Override
  public Maybe<Height> getHeight(Planet planet) {
    return Maybe.just(repository.findByName(planet.getName())).blockingGet()
      .map(p -> calculateJump.calculate(p))
      .defaultIfEmpty(new Height());
  }
}
