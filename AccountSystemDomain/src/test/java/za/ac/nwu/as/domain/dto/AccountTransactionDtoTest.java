package za.ac.nwu.as.domain.dto;

import org.junit.Test;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.as.domain.persistence.AccountType;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AccountTransactionDtoTest {

    @Test
    public void getTransactionId() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto(123,"accountTypeMnemonic",121,23,LocalDate.now());
        assertNotNull(accountTransactionDto.getTransactionId());
    }

    @Test
    public void getAccountTypeMnemonic() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        assertNull(accountTransactionDto.getAccountTypeMnemonic());
    }

    @Test
    public void getMemberId() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto(123,"accountTypeMnemonic",121,23,LocalDate.now());
        assertNotNull(accountTransactionDto.getMemberId());
    }

    @Test
    public void getAmount() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto(123,"accountTypeMnemonic",121,23,LocalDate.now());
        assertNotNull(accountTransactionDto.getAmount());
    }

    @Test
    public void getTransactionDate() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        assertNull(accountTransactionDto.getTransactionDate());
    }

    @Test
    public void setAmount() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        accountTransactionDto.setAmount(100);
    }

    @Test
    public void setMemberId() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        accountTransactionDto.setMemberId(1242);
    }

    @Test
    public void setAccountTypeMnemonic() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        accountTransactionDto.setAccountTypeMnemonic("accountTypeMnemonic");
    }

    @Test
    public void setTransactionId() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        accountTransactionDto.setTransactionId(1242);
    }

    @Test
    public void AccountTransactionDto() {
        AccountType accountType = new AccountType();
        AccountTransaction accountTransaction = new AccountTransaction(123,accountType,456,100,LocalDate.now());
        AccountTransactionDetailsDto details = new AccountTransactionDetailsDto();
        AccountTransactionDto accountTransactionDto01 = new AccountTransactionDto(123,"accountTypeMnemonic",345,1500,LocalDate.now());
        AccountTransactionDto accountTransactionDto02 = new AccountTransactionDto(123,"accountTypeMnemonic",345,1500,LocalDate.now(), details);
        accountTransactionDto01.buildAccountTransaction(accountType);
        AccountTransactionDto accountTransactionDto03 = new AccountTransactionDto(accountTransaction);
        accountTransactionDto01.toString();
        accountTransactionDto01.equals(accountTransactionDto02);
        accountTransactionDto01.hashCode();
    }


    @Test
    public void getDetails() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        assertNull(accountTransactionDto.getDetails());
    }

    @Test
    public void setDetails() {
        AccountTransactionDetailsDto details = new AccountTransactionDetailsDto();
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        accountTransactionDto.setDetails(details);
    }

    @Test
    public void setTransactionDate() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        accountTransactionDto.setTransactionDate(LocalDate.now());
    }


}