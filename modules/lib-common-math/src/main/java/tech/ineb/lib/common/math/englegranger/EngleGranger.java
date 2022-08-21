package tech.ineb.ats.alpha.math.englegranger;


import tech.ineb.ats.alpha.ex.strategy.math.EngleGrangerEx;

/**
 * Created by Dmitry.Erohin dim777@ya.ru on 25.04.2017.
 * Copyright (C) 2017 - present by <a href="https://www.ineb.ru/">Ineb Inc</a>.
 * Please see distribution for license.
 */
public final class EngleGranger {
    private double[][] series;

    public EngleGranger() {
    }

    public EngleGranger setSeries(double[][] series) {
        this.series = series;
        return this;
    }

    public EngleGrangerResult calculate() {
        if (series.length < 2) throw new EngleGrangerEx("Series trade is not enough");
        EngleGrangerMethod engleGrangerMethod = new EngleGrangerMethod(series);
        return engleGrangerMethod.calculate();
    }
}
