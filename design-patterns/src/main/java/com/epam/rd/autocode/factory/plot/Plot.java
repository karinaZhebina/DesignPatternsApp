package com.epam.rd.autocode.factory.plot;

public class Plot {
  private String thePlot;

  public Plot(String plot) {
    this.thePlot = plot;
  }

  @Override
  public String toString() {
    return thePlot;
  }
}
