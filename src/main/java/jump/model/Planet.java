package jump.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Planet {

  @JsonProperty
  private String planet;

  public String getPlanet() {
    return planet;
  }

  public void setPlanet(String planet) {
    this.planet = planet;
  }
}
