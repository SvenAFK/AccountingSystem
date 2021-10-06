package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.as.domain.persistence.AccountType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -4574129268923320303L;
    private Integer transactionId;
    private String accountTypeMnemonic;
    private Integer memberId;
    private Integer amount;
    private LocalDate transactionDate;
    private AccountTransactionDetailsDto details;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(int transactionId, String accountTypeMnemonic, int memberId, int amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(int transactionId, String accountTypeMnemonic, int memberId, int amount, LocalDate transactionDate, AccountTransactionDetailsDto details) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.details = details;
    }

    @JsonIgnore
    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.transactionId = accountTransaction.getTransactionId();
        this.accountTypeMnemonic = accountTransaction.getAccountType().getMnemonic();
        this.memberId = accountTransaction.getMemberId();
        this.amount = accountTransaction.getAmount();
        this.transactionDate = accountTransaction.getTransactionDate();
        if (null != accountTransaction.getDetails()) {
            this.details = new AccountTransactionDetailsDto(accountTransaction.getDetails());
            //this.details = accountTransaction.getDetails();
        }
    }

    @JsonIgnore
    public AccountTransaction buildAccountTransaction(AccountType accountType) {
        return new AccountTransaction(this.getTransactionId(), accountType, this.getMemberId(),
                this.getAmount(), this.getTransactionDate());
    }

    @ApiModelProperty(position = 1,
            value = "AccountTransaction Id",
            name = "transactionId",
            notes = "Uniquely identifies the account transaction",
            dataType = "java.lang.Integer",
            example = "1",
            required = true)
    public int getTransactionId() {
        return transactionId;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Mnemonic",
            name = "Mnemonic",
            notes = "Mnemonic that identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getAccountTypeMnemonic() {
        return accountTypeMnemonic;
    }

    @ApiModelProperty(position = 3,
            value = "AccountTransaction MemberId",
            name = "MemberId",
            notes = "Uniquely identifies the account holder",
            dataType = "java.lang.Integer",
            example = "5061",
            required = true)
    public int getMemberId() {
        return memberId;
    }

    @ApiModelProperty(position = 4,
            value = "AccountTransaction Amount",
            name = "Amount",
            notes = "The Account amount",
            dataType = "java.lang.Integer",
            example = "500",
            required = true)
    public int getAmount() {
        return amount;
    }

    @ApiModelProperty(position = 5,
            value = "AccountTransaction Date",
            name = "transactionDate",
            notes = "Date on which the account transaction took place",
            dataType = "java.time.LocalDate",
            example = "2020-01-01",
            required = true)
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public AccountTransactionDetailsDto getDetails() {
        return details;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountTypeMnemonic(String accountTypeMnemonic) {
        this.accountTypeMnemonic = accountTypeMnemonic;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setDetails(AccountTransactionDetailsDto details) {
        this.details = details;
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction() {
        return new AccountTransaction(getTransactionId(), getAccountTransaction().getAccountType(), getMemberId(), getAmount(),getAccountTransaction().getTransactionDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountTypeMnemonic, that.accountTypeMnemonic) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountTypeMnemonic, memberId, amount, transactionDate, details);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionId=" + transactionId +
                ", accountTypeMnemonic='" + accountTypeMnemonic + '\'' +
                ", memberId=" + memberId + '\'' +
                ", amount=" + amount + '\'' +
                ", transactionDate=" + transactionDate + '\'' +
                ", details=" + details +
                '}';
    }
}

