package jump.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Planet {

  @Id
  @GeneratedValue
  private long id;

  private String name;
  private double gravity;

  public String getName() {
    return name;
  }

  public Planet setName(String planet) {
    this.name = planet;
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
