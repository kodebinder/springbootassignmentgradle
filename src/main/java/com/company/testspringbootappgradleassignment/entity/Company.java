package com.company.testspringbootappgradleassignment.entity;

public class Company {
    private long id;
    private String companyId;
    private String companyName;
    private String domicile;
    private int yearOfEstablishment;
    private boolean isActive;

    public Company(){}

    public Company(long id, String companyId, String companyName, String domicile, int yearOfEstablishment, boolean isActive) {
        this.id = id;
        this.companyId = companyId;
        this.companyName = companyName;
        this.domicile = domicile;
        this.yearOfEstablishment = yearOfEstablishment;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public int getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(int yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (yearOfEstablishment != company.yearOfEstablishment) return false;
        if (isActive != company.isActive) return false;
        if (companyId != null ? !companyId.equals(company.companyId) : company.companyId != null) return false;
        if (companyName != null ? !companyName.equals(company.companyName) : company.companyName != null) return false;
        return domicile != null ? domicile.equals(company.domicile) : company.domicile == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (domicile != null ? domicile.hashCode() : 0);
        result = 31 * result + yearOfEstablishment;
        result = 31 * result + (isActive ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", domicile='" + domicile + '\'' +
                ", yearOfEstablishment=" + yearOfEstablishment +
                ", isActive=" + isActive +
                '}';
    }
}
