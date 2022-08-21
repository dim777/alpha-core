package tech.ineb.ats.alpha.math.englegranger;

import tech.ineb.ats.alpha.math.MathFunctions;
import tech.ineb.ats.alpha.math.TestStatistics;
import tech.ineb.ats.alpha.math.hypotesis.Hypotesis;
import tech.ineb.ats.alpha.math.ols.OrdinaryLeastSquares;
import tech.ineb.ats.alpha.math.ols.OrdinaryLeastSquaresResult;

/**
 * Created by Dmitry.Erohin <dim777@ya.ru> on 09.05.2017.
 * Copyright (C) 2017 - present by <a href="https://www.ineb.ru/">Ineb Inc</a>
 * and <a href="https://www.xegex.ru/">Xegex Inc</a> for financial institutions.
 * Please see distribution for license.
 */

final class EngleGrangerMethod implements Hypotesis {
    private double[][] series;

    EngleGrangerMethod(double[][] series){
        this.series = series;
    }

    //TODO: implement hypotesis test
    @Override
    public boolean test() {
        return false;
    }

    public EngleGrangerResult calculate(){
        /** calculate a and b via ols **/
        OrdinaryLeastSquaresResult olsReg1Result = new OrdinaryLeastSquares()
                .setData(series)
                .setOlsLength(series.length)
                .calculate();

        /** calculate residuals reg1**/
        double[] reg1Res = new double[series.length];
        for(int i = 0; i < reg1Res.length; i++){
            reg1Res[i] = series[i][0] - olsReg1Result.getCoeffA() * series[i][1] - olsReg1Result.getCoeffB();
        }

        /** calculate diff **/
        double[] zDiff = MathFunctions.diff(reg1Res);
        double[] zLag1 = new double[zDiff.length];

        System.arraycopy(reg1Res, 0, zLag1, 0, zLag1.length);

        /** calculate a and b for AR1/reg2 **/
        double[][] dataYX_AR1 = new double[zLag1.length][2];
        for(int i = 0; i < zLag1.length; i++){
            dataYX_AR1[i][0] = zDiff[i];
            dataYX_AR1[i][1] = zLag1[i];
        }

        OrdinaryLeastSquaresResult olsReg2Result = new OrdinaryLeastSquares()
                .setData(dataYX_AR1)
                .setOlsLength(dataYX_AR1.length)
                .calculate();

        /** calculate residuals reg2**/
        double[] reg2Res = new double[dataYX_AR1.length];
        for(int i = 0; i < reg2Res.length; i++){
            reg2Res[i] = dataYX_AR1[i][0] - olsReg2Result.getCoeffA() * dataYX_AR1[i][1] - olsReg2Result.getCoeffB();
        }

        /** se calculation **/
        //reg2.res ^ 2 -> sum (reg2.res ^ 2)
        //sse: sum (reg2.res ^ 2) / n
        double sse = MathFunctions.sum(MathFunctions.pow(reg2Res, 2)) / (reg2Res.length - 2);

        //reg1.res ^ 2
        //v1: sqrt(sum(reg1.res ^ 2))
        double v0 = MathFunctions.sum(MathFunctions.pow(reg1Res, 2));
        double v1 = Math.pow(v0, 0.5);

        //se = sse/v1
        double se = sse / v1;

        TestStatistics testStatistics = TestStatistics.of(olsReg2Result.getCoeffA(), se, 420);
        double sValue = testStatistics.calculate();

        boolean h = testStatistics.hypothesisTest();

        return new EngleGrangerResult(olsReg1Result, olsReg2Result, h);
    }
}
