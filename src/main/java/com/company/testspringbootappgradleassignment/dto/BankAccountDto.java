package com.company.testspringbootappgradleassignment.dto;

import java.math.BigDecimal;

public class BankAccountDto {
    private long id;
    private String bankAccountId;
    private String bankAccountNumber;
    private boolean isActive;
    private BigDecimal balance;
    private BankOperationDto bankOperation;

    public BankAccountDto(){}

    public BankAccountDto(long id, String bankAccountId, String bankAccountNumber, boolean isActive, BigDecimal balance, BankOperationDto bankOperation) {
        this.id = id;
        this.bankAccountId = bankAccountId;
        this.bankAccountNumber = bankAccountNumber;
        this.isActive = isActive;
        this.balance = balance;
        this.bankOperation = bankOperation;
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

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BankOperationDto getBankOperation() {
        return bankOperation;
    }

    public void setBankOperation(BankOperationDto bankOperation) {
        this.bankOperation = bankOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccountDto that = (BankAccountDto) o;

        if (id != that.id) return false;
        if (isActive != that.isActive) return false;
        if (bankAccountId != null ? !bankAccountId.equals(that.bankAccountId) : that.bankAccountId != null)
            return false;
        if (bankAccountNumber != null ? !bankAccountNumber.equals(that.bankAccountNumber) : that.bankAccountNumber != null)
            return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        return bankOperation != null ? bankOperation.equals(that.bankOperation) : that.bankOperation == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (bankAccountId != null ? bankAccountId.hashCode() : 0);
        result = 31 * result + (bankAccountNumber != null ? bankAccountNumber.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (bankOperation != null ? bankOperation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BankAccountDto{" +
                "id=" + id +
                ", bankAccountId='" + bankAccountId + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", isActive=" + isActive +
                ", balance=" + balance +
                ", bankOperation=" + bankOperation +
                '}';
    }
}
