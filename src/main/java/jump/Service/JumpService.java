package jump.Service;

import io.reactivex.Single;
import jump.model.Height;
import jump.model.Planet;

public interface JumpService {

  Single<Height> getJumpHeight(Planet planet);

}
