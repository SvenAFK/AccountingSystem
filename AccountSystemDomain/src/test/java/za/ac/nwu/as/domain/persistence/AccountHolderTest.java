package za.ac.nwu.as.domain.persistence;

import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.*;

public class AccountHolderTest {

    @Test
    public void getMemberId() {
        AccountHolder accountHolder = new AccountHolder();
        assertNotNull(accountHolder.getMemberId());
    }

    @Test
    public void getMemberName() {
        AccountHolder accountHolder = new AccountHolder();
        assertNull(accountHolder.getMemberName());
    }

    @Test
    public void getBalance() {
        AccountHolder accountHolder = new AccountHolder();
        assertNotNull(accountHolder.getBalance());
    }

    @Test
    public void getCurrency() {
        AccountHolder accountHolder = new AccountHolder();
        assertNull(accountHolder.getCurrency());
    }

    @Test
    public void getStartDate() {
        AccountHolder accountHolder = new AccountHolder();
        assertNull(accountHolder.getStartDate());
    }

    @Test
    public void setMemberId() {
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setMemberId(1242);
    }

    @Test
    public void setMemberName() {
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setMemberName("John");
    }

    @Test
    public void setBalance() {
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setBalance(1000);
    }

    @Test
    public void setCurrency() {
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setCurrency("MILES");
    }

    @Test
    public void setStartDate() {
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setStartDate(LocalDate.now());

    }

    @Test
    public void AccountHolder() {
        AccountHolder accountHolder01 = new AccountHolder("memberName",1200,"currency",LocalDate.now());
        AccountHolder accountHolder02 = new AccountHolder(123,"memberName",1200,"currency",LocalDate.now());
        accountHolder01.toString();
        accountHolder01.equals(accountHolder02);
        accountHolder01.hashCode();
    }

}