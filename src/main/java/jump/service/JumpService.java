package jump.service;

import io.reactivex.Maybe;
import io.reactivex.Single;
import jump.domain.Planet;
import jump.model.Height;

public interface JumpService {

  Maybe<Height> getHeight(Planet planet);

  Single<Planet> putPlanet(Planet planet);

}
