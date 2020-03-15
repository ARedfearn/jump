package jump.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Height {

  private double meters;
  private String planet;

  public double getMeters() {
    return meters;
  }

  public void setMeters(double meters) {
    this.meters = meters;
  }

  public String getPlanet() {
    return planet;
  }

  public void setPlanet(String planet) {
    this.planet = planet;
  }
}