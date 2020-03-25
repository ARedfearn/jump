package jump;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.micronaut.test.annotation.MicronautTest;
import jump.domain.Planet;
import jump.model.Height;
import jump.util.CalculateJump;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MicronautTest
public class CalculateJumpSpec {

  Planet planet;

  @BeforeEach
  void populatePlanet() {
    planet = new Planet();
    planet.setName("Pluto");
    planet.setGravity(0.62);
  }

  @Test
  void shouldCalculateJump() {
    CalculateJump calculateJump = new CalculateJump();
    Height height = calculateJump.calculate(planet);

    assertEquals(height.getMeters(), 7.91);
  }

}
