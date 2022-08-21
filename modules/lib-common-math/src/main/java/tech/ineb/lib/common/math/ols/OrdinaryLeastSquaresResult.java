package tech.ineb.ats.alpha.math.ols;

/**
 * Created by rb052775 on 20.02.2017.
 */
public final class OrdinaryLeastSquaresResult {
    private final double coeffA;
    private final double coeffB;
    private final double rmse;

    OrdinaryLeastSquaresResult(double coeffA, double coeffB, double rmse) {
        this.coeffA = coeffA;
        this.coeffB = coeffB;
        this.rmse = rmse;
    }

    public double getCoeffA() {
        return coeffA;
    }

    public double getCoeffB() {
        return coeffB;
    }

    public double getRmse() {
        return rmse;
    }
}
