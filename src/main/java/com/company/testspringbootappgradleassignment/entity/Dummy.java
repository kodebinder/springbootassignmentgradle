package com.company.testspringbootappgradleassignment.entity;

public class Dummy {
    private long id;
    private String dummyField1;
    private String dummyField2;
    private String dummyField3;

    public Dummy(){}

    public Dummy(long id, String dummyField1, String dummyField2, String dummyField3) {
        this.id = id;
        this.dummyField1 = dummyField1;
        this.dummyField2 = dummyField2;
        this.dummyField3 = dummyField3;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDummyField1() {
        return dummyField1;
    }

    public void setDummyField1(String dummyField1) {
        this.dummyField1 = dummyField1;
    }

    public String getDummyField2() {
        return dummyField2;
    }

    public void setDummyField2(String dummyField2) {
        this.dummyField2 = dummyField2;
    }

    public String getDummyField3() {
        return dummyField3;
    }

    public void setDummyField3(String dummyField3) {
        this.dummyField3 = dummyField3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dummy dummy = (Dummy) o;

        if (id != dummy.id) return false;
        if (dummyField1 != null ? !dummyField1.equals(dummy.dummyField1) : dummy.dummyField1 != null) return false;
        if (dummyField2 != null ? !dummyField2.equals(dummy.dummyField2) : dummy.dummyField2 != null) return false;
        return dummyField3 != null ? dummyField3.equals(dummy.dummyField3) : dummy.dummyField3 == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (dummyField1 != null ? dummyField1.hashCode() : 0);
        result = 31 * result + (dummyField2 != null ? dummyField2.hashCode() : 0);
        result = 31 * result + (dummyField3 != null ? dummyField3.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "id=" + id +
                ", dummyField1='" + dummyField1 + '\'' +
                ", dummyField2='" + dummyField2 + '\'' +
                ", dummyField3='" + dummyField3 + '\'' +
                '}';
    }
}
