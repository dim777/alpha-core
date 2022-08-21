package ru.xegex.commons.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
public abstract class AbstractEntity1 {
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity1 that = (AbstractEntity1) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
