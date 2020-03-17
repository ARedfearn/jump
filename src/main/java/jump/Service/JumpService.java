package jump.Service;

import io.reactivex.Maybe;
import jump.model.Height;
import jump.model.Planet;

public interface JumpService {

  Maybe<Height> getHeight(Planet planet);

}
