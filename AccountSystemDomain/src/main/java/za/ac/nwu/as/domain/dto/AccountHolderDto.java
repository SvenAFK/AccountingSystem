package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountHolder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountHolder", description = "A DTO that represents the AccountHolder (member)")

public class AccountHolderDto implements Serializable {

    private static final long serialVersionUID = -5566983671858386439L;
    private String memberName;
    private Integer balance;
    private String currency;
    private LocalDate startDate;

    public AccountHolderDto() {
    }

    public AccountHolderDto(String memberName, int balance, String currency, LocalDate startDate) {
        this.memberName = memberName;
        this.balance = balance;
        this.currency = currency;
        this.startDate = startDate;
    }

    public AccountHolderDto(AccountHolder accountHolder) {
        this.setMemberName(accountHolder.getMemberName());
        this.setBalance(accountHolder.getBalance());
        this.setCurrency(accountHolder.getCurrency());
        this.setStartDate(accountHolder.getStartDate());
    }

    @ApiModelProperty(position = 1,
            value = "AccountHolder Name",
            name = "Name",
            notes = "The name of the AccountHolder",
            dataType = "java.lang.String",
            example = "John",
            required = true)

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @ApiModelProperty(position = 2,
            value = "AccountHolder Balance",
            name = "Balance",
            notes = "The balance of the AccountHolder",
            dataType = "java.lang.Integer",
            example = "5000",
            required = true)

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @ApiModelProperty(position = 3,
            value = "AccountHolder Currency",
            name = "Currency",
            notes = "The currency of the AccountHolder",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @ApiModelProperty(position = 3,
            value = "AccountHolder Start Date",
            name = "StartDate",
            notes = "This is the start date on which to add Miles/Currency for a member",
            dataType = "java.time.LocalDate",
            example = "2020-01-01",
            allowEmptyValue = true)

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountHolderDto that = (AccountHolderDto) o;
        return Objects.equals(memberName, that.memberName) && Objects.equals(balance, that.balance) && Objects.equals(currency, that.currency) && Objects.equals(startDate, that.startDate);
    }

    @JsonIgnore
    public AccountHolder getAccountHolder() {
        return new AccountHolder(getMemberName(), getBalance(), getCurrency(), getStartDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberName, balance, currency, startDate);
    }
}
