package jump.util;

import jump.model.Height;
import jump.domain.Planet;

import javax.inject.Singleton;

@Singleton
public class CalculateJump {

  private static final double earthGravity = 9.81;
  private static final double earthJumpHeight = 0.5;

  public Height calculate(Planet planet) {
    double hostPlanetGravity = planet.getGravity();
    double conversionFactor = earthGravity / hostPlanetGravity;
    double hostPlanetJumpHeight = earthJumpHeight * conversionFactor;

    Height height = new Height();
    height.setMeters(hostPlanetJumpHeight);

    return height;
  }
}