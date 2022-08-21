package ru.xegex.commons.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
public class TestEntity {
    private Long id;
    private Integer iVal;
    private Double dVal;
    private Long lVal;
    private float fVal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return Float.compare(that.fVal, fVal) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(iVal, that.iVal) &&
                Objects.equals(dVal, that.dVal) &&
                Objects.equals(lVal, that.lVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iVal, dVal, lVal, fVal);
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", iVal=" + iVal +
                ", dVal=" + dVal +
                ", lVal=" + lVal +
                ", fVal=" + fVal +
                '}';
    }
}
