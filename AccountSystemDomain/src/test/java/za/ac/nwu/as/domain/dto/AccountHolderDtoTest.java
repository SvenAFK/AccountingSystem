package za.ac.nwu.as.domain.dto;

import org.junit.Test;
import za.ac.nwu.as.domain.persistence.AccountHolder;
import java.time.LocalDate;
import static org.junit.Assert.*;

public class AccountHolderDtoTest {

    @Test
    public void getMemberName() {
        AccountHolderDto accountHolderDto = new AccountHolderDto();
        assertNull(accountHolderDto.getMemberName());
    }

    @Test
    public void getCurrency() {
        AccountHolderDto accountHolderDto = new AccountHolderDto();
        assertNull(accountHolderDto.getCurrency());
    }

    @Test
    public void getStartDate() {
        AccountHolderDto accountHolderDto = new AccountHolderDto();
        assertNull(accountHolderDto.getStartDate());
    }

    @Test
    public void getAccountHolder() {
        AccountHolderDto accountHolderDto = new AccountHolderDto("memberName",1500,"MILES,",LocalDate.now());
        assertNotNull(accountHolderDto.getAccountHolder());
    }

    @Test
    public void setMemberName(){
        AccountHolderDto accountHolderDto = new AccountHolderDto();
        accountHolderDto.setMemberName("John");
    }

    @Test
    public void setBalance(){
        AccountHolderDto accountHolderDto = new AccountHolderDto();
        accountHolderDto.setBalance(1000);
    }

    @Test
    public void setCurrency(){
        AccountHolderDto accountHolderDto = new AccountHolderDto();
        accountHolderDto.setCurrency("MILES");
    }
    @Test
    public void setStartDate(){
        AccountHolderDto accountHolderDto = new AccountHolderDto();
        accountHolderDto.setStartDate(LocalDate.now());
    }

    @Test
    public void AccountHolder() {
        AccountHolder accountHolder = new AccountHolder();
        AccountHolderDto accountHolderDto01 = new AccountHolderDto("memberName",1500,"MILES,",LocalDate.now());
        AccountHolderDto accountHolderDto02 = new AccountHolderDto(accountHolder);
        accountHolderDto01.getBalance();
        accountHolderDto01.hashCode();
        accountHolderDto01.equals(accountHolderDto02);
    }

}