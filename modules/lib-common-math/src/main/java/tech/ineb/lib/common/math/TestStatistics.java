package tech.ineb.ats.alpha.math;

/**
 * Created by Dmitry.Erohin <dim777@ya.ru> on 15.04.2017.
 * Copyright (C) 2017 - present by <a href="https://www.ineb.ru/">Ineb Inc</a>
 * and <a href="https://www.xegex.ru/">Xegex Inc</a> for financial institutions.
 * Please see distribution for license.
 */

public final class TestStatistics {
    private final static double[] CRITICAL_VALUES = new double[1000];

    private double phi;
    private double se;
    private int n;

    {
        CRITICAL_VALUES[419] = -3.35168;
    }

    public static TestStatistics of(double phi, double se, int n){
        return new TestStatistics(phi, se, n);
    }


    private TestStatistics(double phi, double se, int n){
        this.phi = phi;
        this.se = se;
        this.n = n;
    }

    public double calculate(){
        //Assert se not null
        return phi / se;
    }

    public boolean hypothesisTest(){
        double tStat = this.calculate();
        double cValue = this.getCriticalValue(this.n);
        if(tStat < cValue) return true;
        return false;
    }

    /**
     * Get critical value by n
     * @param n
     * @return
     */
    public static double getCriticalValue(int n){
        //Assert > 0 < CRITICAL_VALUES.lenght
        return CRITICAL_VALUES[n - 1];
    }
}
