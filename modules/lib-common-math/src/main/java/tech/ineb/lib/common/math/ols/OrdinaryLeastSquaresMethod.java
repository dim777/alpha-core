package tech.ineb.ats.alpha.math.ols;

/**
 * Created by Dmitry.Erohin dim777@ya.ru on 11.04.2017.
 * Copyright (C) 2017 - present by <a href="https://www.ineb.ru/">Ineb Inc</a>.
 * Please see distribution for license.
 */
final class OrdinaryLeastSquaresMethod {
    private final int olsLength;
    private final double[][] data;

    OrdinaryLeastSquaresMethod(double[][] data) {
        this.data = data;
        this.olsLength = data.length;
    }

    OrdinaryLeastSquaresMethod(double[][] data, int olsLength) {
        this.data = data;
        this.olsLength = olsLength;
    }

    final OrdinaryLeastSquaresResult calculate() {
        double x = 0, y = 0, xy = 0, x2 = 0;
        for (int i = data.length - olsLength; i < data.length; i++) {
            x += data[i][1];
            y += data[i][0];
            xy += data[i][0] * data[i][1];
            x2 += Math.pow(data[i][1], 2);
        }
        double coeffA = (olsLength * xy - x * y) / (olsLength * x2 - Math.pow(x, 2));
        double coeffB = (y - coeffA * x) / olsLength;

        double y_rmse = 0, y_rmse1 = 0;

        //Оценка погрешности метода наименьших квадратов.
        for (int i = data.length - olsLength; i < data.length; i++) {
            y_rmse1 = coeffA * data[i][1] + coeffB;
            y_rmse += Math.pow(data[i][0] - y_rmse1, 2);
        }
        double rmse = Math.sqrt(y_rmse / (olsLength - 2));
        return new OrdinaryLeastSquaresResult(coeffA, coeffB, rmse);
    }

}
