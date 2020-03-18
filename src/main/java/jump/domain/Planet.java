package jump.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Planet {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private double gravity;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getGravity() {
    return gravity;
  }

  public void setGravity(double gravity) {
    this.gravity = gravity;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
