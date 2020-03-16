package jump.Util;

import io.reactivex.Single;
import jump.model.Height;
import jump.model.Planet;

import javax.inject.Singleton;

@Singleton
public class CalculateJump {

  //Meters per second squared
  private static final double earthGravity = 9.81;
  //Meters
  private static final double earthJumpHeight = 0.5;

  public Single<Height> calculate(Planet planet) {
    //Height of Jump on host planet = (earthGravity / hostPlanetGravity) * Height of Jump on Earth

    return Single.just(planet)
      .map(Planet::getGravity)
      .map(hostPlanetGravity -> earthGravity / hostPlanetGravity)
      .map(conversionFactor -> earthJumpHeight * conversionFactor)
      .map(hostPlanetJumpHeight -> {
        Height height = new Height();
        height.setMeters(hostPlanetJumpHeight);
        return height;
      });
  }
}