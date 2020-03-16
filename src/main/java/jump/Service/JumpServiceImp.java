package jump.Service;

import io.reactivex.Single;
import jump.Util.CalculateJump;
import jump.model.Height;
import jump.model.Planet;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JumpServiceImp implements JumpService {

  private CalculateJump calculateJump;

  @Inject
  public JumpServiceImp(CalculateJump calculateJump) {
    this.calculateJump = calculateJump;
  }


  @Override
  public Single<Height> getJumpHeight(Planet planet) {
    return Single.just(planet)
      .map(p -> p.setGravity(24.79))
      .flatMap(p -> calculateJump.calculate(p));
  }
}
