package tech.ineb.ats.alpha.math.ols;

import tech.ineb.ats.alpha.ex.strategy.math.OrdinaryLeastSquaresEx;

/**
 * Created by Dmitry.Erohin <dim777@ya.ru> on 08.05.2017.
 * Copyright (C) 2017 - present by <a href="https://www.ineb.ru/">Ineb Inc</a>
 * and <a href="https://www.xegex.ru/">Xegex Inc</a> for financial institutions.
 * Please see distribution for license.
 */
public class OrdinaryLeastSquares {
    private int olsLength;
    private double[][] data;

    public OrdinaryLeastSquares() {
    }

    public OrdinaryLeastSquares setOlsLength(int olsLength) {
        this.olsLength = olsLength;
        return this;
    }

    public OrdinaryLeastSquares setData(double[][] data) {
        this.data = data;
        return this;
    }

    public OrdinaryLeastSquaresResult calculate() {
        if (olsLength == 0 || data == null) throw new OrdinaryLeastSquaresEx("Please set params for OLS calculation");
        OrdinaryLeastSquaresMethod ordinaryLeastSquaresMethod = new OrdinaryLeastSquaresMethod(data, olsLength);
        return ordinaryLeastSquaresMethod.calculate();
    }

}
