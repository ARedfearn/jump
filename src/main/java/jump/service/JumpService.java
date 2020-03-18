package jump.service;

import io.reactivex.Maybe;
import io.reactivex.Single;
import jump.model.Height;
import jump.domain.Planet;

public interface JumpService {

  Maybe<Height> getHeight(Planet planet);

  Single<Planet> putPlanet(Planet planet);

}
