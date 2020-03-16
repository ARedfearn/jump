package jump.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Height {

  @JsonProperty
  private double meters;

  public double getMeters() {
    return meters;
  }

  public void setMeters(double meters) {
    this.meters = meters;
  }
}