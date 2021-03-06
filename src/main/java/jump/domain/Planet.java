package jump.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Introspected
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Planet {

  @Id
  @GeneratedValue
  private Long id;

  @NotBlank(message = "Name is required")
  private String name;

  @NotNull(message = "Gravity is required")
  @Column(precision = 10, scale = 2)
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
