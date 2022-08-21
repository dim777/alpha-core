package tech.ineb.ats.alpha.math.englegranger;

import tech.ineb.ats.alpha.math.ols.OrdinaryLeastSquaresResult;

/**
 * Created by rb052775 on 20.02.2017.
 */
public final class EngleGrangerResult{
    private OrdinaryLeastSquaresResult reg1Result;
    private OrdinaryLeastSquaresResult reg2Result;
    private boolean h;

    EngleGrangerResult(OrdinaryLeastSquaresResult reg1Result, OrdinaryLeastSquaresResult reg2Result, boolean h){
        this.reg1Result = reg1Result;
        this.reg2Result = reg2Result;
        this.h = h;
    }

    public OrdinaryLeastSquaresResult getReg1Result() {
        return reg1Result;
    }

    public OrdinaryLeastSquaresResult getReg2Result() {
        return reg2Result;
    }

    public boolean isH() {
        return h;
    }
}
