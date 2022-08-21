package tech.ineb.ats.alpha.math;

/**
 * Created by Dmitry.Erohin dim777@ya.ru on 25.04.2017.
 * Copyright (C) 2017 - present by <a href="https://www.ineb.ru/">Ineb Inc</a>.
 * Please see distribution for license.
 */
public final class MathFunctions {
    private MathFunctions() {

    }

    public static double[] diff(double[] values) {
        double[] diffArray = new double[values.length - 1];
        for (int i = 0; i < diffArray.length; i++) {
            diffArray[i] = values[i + 1] - values[i];
        }
        return diffArray;
    }

    public static double sum(double[] values) {
        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static double[] pow(double[] values, double pow) {
        double[] retArr = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            retArr[i] = Math.pow(values[i], pow);
        }
        return retArr;
    }
}
