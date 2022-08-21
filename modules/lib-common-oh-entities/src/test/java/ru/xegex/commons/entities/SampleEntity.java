package ru.xegex.commons.entities;

import java.util.Objects;

public class SampleEntity {
    private int id;
    private Integer _id;
    private boolean flag;
    private Boolean _flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Boolean get_flag() {
        return _flag;
    }

    public void set_flag(Boolean _flag) {
        this._flag = _flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleEntity that = (SampleEntity) o;
        return id == that.id &&
                flag == that.flag &&
                Objects.equals(_id, that._id) &&
                Objects.equals(_flag, that._flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, _id, flag, _flag);
    }

    @Override
    public String toString() {
        return "SampleEntity{" +
                "id=" + id +
                ", _id=" + _id +
                ", flag=" + flag +
                ", _flag=" + _flag +
                '}';
    }
}
