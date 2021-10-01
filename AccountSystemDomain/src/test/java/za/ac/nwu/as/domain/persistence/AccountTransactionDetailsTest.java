package za.ac.nwu.as.domain.persistence;

import org.junit.Test;
import za.ac.nwu.as.domain.dto.AccountTransactionDetailsDto;

import static org.junit.Assert.*;

public class AccountTransactionDetailsTest {

    @Test
    public void getAccountTransactionDetailsId() {
        AccountTransactionDetails accountTransactionDetails = new AccountTransactionDetails();
        assertNotNull(accountTransactionDetails.getAccountTransactionDetailsId());
    }

    @Test
    public void getAccountTransaction() {
        AccountTransactionDetails accountTransactionDetails = new AccountTransactionDetails();
        assertNull(accountTransactionDetails.getAccountTransaction());
    }

    @Test
    public void getPartnerName() {
        AccountTransactionDetails accountTransactionDetails = new AccountTransactionDetails();
        assertNull(accountTransactionDetails.getPartnerName());
    }

    @Test
    public void getNumberOfItems() {
        AccountTransactionDetails accountTransactionDetails = new AccountTransactionDetails("partnerName",150);
        assertNotNull(accountTransactionDetails.getNumberOfItems());
    }

    @Test
    public void setAccountTransactionDetailsId() {
        AccountTransactionDetails accountTransactionDetails = new AccountTransactionDetails();
        accountTransactionDetails.setAccountTransactionDetailsId(123);
    }

    @Test
    public void setAccountTransaction() {
        AccountTransaction accountTransaction = new AccountTransaction();
        AccountTransactionDetails accountTransactionDetails = new AccountTransactionDetails();
        accountTransactionDetails.setAccountTransaction(accountTransaction);
    }

    @Test
    public void setPartnerName() {
        AccountTransactionDetails accountTransactionDetails = new AccountTransactionDetails();
        accountTransactionDetails.setPartnerName("Test");
    }

    @Test
    public void setNumberOfItems() {
        AccountTransactionDetails accountTransactionDetails = new AccountTransactionDetails();
        accountTransactionDetails.setNumberOfItems(124);
    }

    @Test
    public void buildAccountTransactionDetails() {
        AccountTransaction accountTransaction = new AccountTransaction();
        AccountTransactionDetails accountTransactionDetails = new AccountTransactionDetails(accountTransaction,"PartnerName", 124);
        AccountTransactionDetails accountTransactionDetails01 = new AccountTransactionDetails("PartnerName", 124);
        accountTransactionDetails01.buildAccountTransactionDetails(accountTransaction);
    }
}