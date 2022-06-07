package com.epam.rd.autocode.factory.plot;

public class MarvelPlotFactory implements PlotFactory {
  private final Character[] heroes;
  private final EpicCrisis epicCrisis;
  private final Character villain;

  public MarvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
    this.heroes = heroes;
    this.epicCrisis = epicCrisis;
    this.villain = villain;
  }

  @Override
  public Plot plot() {
    StringBuilder braveHeroes = new StringBuilder();
    for (int i = 0; i < heroes.length; i++) {
      if (i > 0) {
        braveHeroes.append(",");
      }
      braveHeroes.append(" brave ").append(heroes[i].name());
    }
    return new Plot(epicCrisis.name() + " threatens the world. But" + braveHeroes +
        " on guard. So, no way that intrigues of " + villain.name() + " overcome the willpower of inflexible heroes");
  }
}
