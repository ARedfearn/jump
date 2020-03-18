package jump.model;

import java.text.DecimalFormat;

public class Height {

  private static final DecimalFormat df = new DecimalFormat("#0.00");

  private double meters;

  public double getMeters() {
    return meters;
  }

  public void setMeters(double meters) {
    this.meters = Double.parseDouble(df.format(meters));;
  }
}