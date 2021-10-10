package za.ac.nwu.as.domain.dto;

import org.junit.Test;
import za.ac.nwu.as.domain.persistence.AccountType;
import java.time.LocalDate;
import static org.junit.Assert.*;

public class AccountTypeDtoTest {

    @Test
    public void getMnemonic() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        assertNull(accountTypeDto.getMnemonic());
    }

    @Test
    public void setMnemonic() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        accountTypeDto.setMnemonic("MILES");
    }

    @Test
    public void getAccountTypeName() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        assertNull(accountTypeDto.getAccountTypeName());
    }

    @Test
    public void setAccountTypeName() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        accountTypeDto.setAccountTypeName("accountTypeName");
    }

    @Test
    public void getCreationDate() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        assertNull(accountTypeDto.getCreationDate());
    }

    @Test
    public void setCreationDate() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        accountTypeDto.setCreationDate(LocalDate.now());
    }

    @Test
    public void getAccountType() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        assertNotNull(accountTypeDto.getAccountType());
    }

    @Test
    public void AccountTypeDto() {
        AccountType accountType = new AccountType(123,"accountMnemonic","AccountTypeName",LocalDate.now());
        AccountTypeDto accountTypeDto2 = new AccountTypeDto(accountType);
        AccountTypeDto accountTypeDto1 = new AccountTypeDto("accountMnemonic","AccountTypeName",LocalDate.now());
        accountTypeDto1.toString();
        accountTypeDto1.equals(accountTypeDto2);
        accountTypeDto1.hashCode();
    }
}