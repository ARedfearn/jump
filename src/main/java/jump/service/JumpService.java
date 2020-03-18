package jump.service;

import io.reactivex.Maybe;
import jump.model.Height;
import jump.domain.Planet;

public interface JumpService {

  Maybe<Height> getHeight(Planet planet);

}
