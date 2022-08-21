package ru.xegex.commons.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class TestEntity1 extends AbstractEntity1 {
    private static TestEntity1 INSTANCE;

    private double dVal;
    private long lVal;
    private Float fVal;
    private char cVal;

    public static TestEntity1 instance() {
        if (Objects.isNull(INSTANCE)) {
            synchronized (TestEntity1.class) {
                if (Objects.isNull(INSTANCE)) {
                    INSTANCE = new TestEntity1();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TestEntity1 that = (TestEntity1) o;
        return Double.compare(that.dVal, dVal) == 0 &&
                lVal == that.lVal &&
                cVal == that.cVal &&
                fVal.equals(that.fVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dVal, lVal, fVal, cVal);
    }

    @Override
    public String toString() {
        return "TestEntity1{" +
                "dVal=" + dVal +
                ", lVal=" + lVal +
                ", fVal=" + fVal +
                ", cVal=" + cVal +
                '}';
    }
}
