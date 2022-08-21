package tech.ineb.ats.alpha.strategy;

import tech.ineb.ats.alpha.utils.Pair;

public interface Strategy<T, R extends Number> {
    String DEFAULT_NAME = "Strategy";
    String DEFAULT_DESCRIPTION = "Description";

    String getName();

    String getDescription();

    String[] getSecurities();

    void pre(Pair<T, T> pair);

    R getResult();
}
