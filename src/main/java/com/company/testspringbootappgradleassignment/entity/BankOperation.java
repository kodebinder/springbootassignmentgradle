package com.company.testspringbootappgradleassignment.entity;

public class BankOperation {
    private long id;
    private String bankAccountId;
    private boolean isDebitEnabled;
    private boolean isCreditEnabled;

    public BankOperation(){}

    public BankOperation(long id, String bankAccountId, boolean isDebitEnabled, boolean isCreditEnabled) {
        this.id = id;
        this.bankAccountId = bankAccountId;
        this.isDebitEnabled = isDebitEnabled;
        this.isCreditEnabled = isCreditEnabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public boolean isDebitEnabled() {
        return isDebitEnabled;
    }

    public void setDebitEnabled(boolean debitEnabled) {
        isDebitEnabled = debitEnabled;
    }

    public boolean isCreditEnabled() {
        return isCreditEnabled;
    }

    public void setCreditEnabled(boolean creditEnabled) {
        isCreditEnabled = creditEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankOperation that = (BankOperation) o;

        if (id != that.id) return false;
        if (isDebitEnabled != that.isDebitEnabled) return false;
        if (isCreditEnabled != that.isCreditEnabled) return false;
        return bankAccountId != null ? bankAccountId.equals(that.bankAccountId) : that.bankAccountId == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (bankAccountId != null ? bankAccountId.hashCode() : 0);
        result = 31 * result + (isDebitEnabled ? 1 : 0);
        result = 31 * result + (isCreditEnabled ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BankOperation{" +
                "id=" + id +
                ", bankAccountId='" + bankAccountId + '\'' +
                ", isDebitEnabled=" + isDebitEnabled +
                ", isCreditEnabled=" + isCreditEnabled +
                '}';
    }
}

