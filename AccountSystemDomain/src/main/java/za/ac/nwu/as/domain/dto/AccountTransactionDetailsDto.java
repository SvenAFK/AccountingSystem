package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.AccountTransactionDetails;
import java.util.Objects;

public class AccountTransactionDetailsDto {

    String partnerName;
    Integer numberOfItems;

    public AccountTransactionDetailsDto() {
    }

    public AccountTransactionDetailsDto(String partnerName, int numberOfItems) {
        this.partnerName = partnerName;
        this.numberOfItems = numberOfItems;
    }

    public AccountTransactionDetailsDto(AccountTransactionDetails details) {
        this.partnerName = details.getPartnerName();
        this.numberOfItems = details.getNumberOfItems();
    }

    @JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails(AccountTransaction accountTransaction) {
        return new AccountTransactionDetails(accountTransaction, this.partnerName, this.numberOfItems);
    }

    //@JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails() {
        return new AccountTransactionDetails(this.partnerName, this.numberOfItems);
    }

    @ApiModelProperty(position = 1,
            value = "AccountTransactionDetails PartnerName",
            name = "PartnerName",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "ABC_Company",
            required = true)
    public String getPartnerName() {
        return partnerName;
    }

    @ApiModelProperty(position = 2,
            value = "AccountTransactionDetails NumberOfItems",
            name = "MemberId",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.Integer",
            example = "12",
            required = true)
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDetailsDto that = (AccountTransactionDetailsDto) o;
        return Objects.equals(partnerName, that.partnerName) && Objects.equals(numberOfItems, that.numberOfItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partnerName, numberOfItems);
    }

    @Override
    public String toString() {
        return "AccountTransactionDetailsDto{" +
                "partnerName='" + partnerName + '\'' +
                ", numberOfItems=" + numberOfItems +
                '}';
    }
}
