package za.ac.nwu.as.domain.persistence;

import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.*;

public class AccountTransactionTest {

    @Test
    public void getTransactionId() {
        AccountTransaction accountTransaction = new AccountTransaction();
        assertNotNull(accountTransaction.getTransactionId());
    }

    @Test
    public void getMemberId() {
        AccountTransaction accountTransaction = new AccountTransaction();
        assertNotNull(accountTransaction.getMemberId());
    }

    @Test
    public void getAmount() {
        AccountTransaction accountTransaction = new AccountTransaction();
        assertNotNull(accountTransaction.getAmount());
    }

    @Test
    public void getTransactionDate() {
        AccountTransaction accountTransaction = new AccountTransaction();
        assertNull(accountTransaction.getTransactionDate());
    }

    @Test
    public void getAccountType() {
        AccountTransaction accountTransaction = new AccountTransaction();
        assertNull(accountTransaction.getAccountType());
    }

    @Test
    public void getDetails() {
        AccountTransaction accountTransaction = new AccountTransaction();
        assertNull(accountTransaction.getDetails());
    }

    @Test
    public void setTransactionId() {
        AccountTransaction accountTransaction = new AccountTransaction();
        accountTransaction.setTransactionId(1242);
    }

    @Test
    public void setMemberId() {
        AccountTransaction accountTransaction = new AccountTransaction();
        accountTransaction.setMemberId(1242);
    }

    @Test
    public void setAmount() {
        AccountTransaction accountTransaction = new AccountTransaction();
        accountTransaction.setAmount(100);
    }

    @Test
    public void setTransactionDate() {
        AccountTransaction accountTransaction = new AccountTransaction();
        accountTransaction.setTransactionDate(LocalDate.now());
    }


    @Test
    public void setDetails() {
        AccountTransactionDetails details = new AccountTransactionDetails();
        AccountTransaction accountTransaction = new AccountTransaction();
        accountTransaction.setDetails(details);
    }

    @Test
    public void setAccountType() {
        AccountType accountType = new AccountType();
        AccountTransaction accountTransaction = new AccountTransaction();
        accountTransaction.setAccountType(accountType);

        AccountTransaction accountTransaction01 = new AccountTransaction(123,accountType,456,100,LocalDate.now());
        accountTransaction01.toString();
        accountTransaction01.hashCode();
        accountTransaction01.equals(accountTransaction);
    }


}