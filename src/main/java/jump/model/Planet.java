package jump.model;

public class Planet {

  private String planet;
  private double gravity;

  public String getPlanet() {
    return planet;
  }

  public Planet setPlanet(String planet) {
    this.planet = planet;
    return this;
  }

  public double getGravity() {
    return gravity;
  }

  public Planet setGravity(double gravity) {
    this.gravity = gravity;
    return this;
  }
}
