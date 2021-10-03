package za.ac.nwu.as.logic.flow.impl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.dto.AccountTransactionDetailsDto;
import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.translator.AccountTransactionTranslator;
import java.time.LocalDate;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTransactionFlowImplTest {

    @Mock
    private AccountTransactionTranslator translator;

    @InjectMocks
    private CreateAccountTransactionFlowImpl flow;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {

    }

    /*
    @Test
    public void create() {
        AccountType accountType = new AccountType(123L,"accountMnemonic","AccountTypeName",LocalDate.now());
        AccountTransaction accountTransaction = new AccountTransaction(123L,accountType,456L,100L,LocalDate.now());
        AccountTransactionDetails details = new AccountTransactionDetails(accountTransaction,"partnerName",12L);
        when(translator.create(any(AccountTransactionDto.class))).thenReturn(null);
        AccountTransactionDto result = flow.create((new AccountTransactionDto(123L,"accountTypeMnemonic",456L,1500L, LocalDate.now(), details)));
        assertNull(result);
        verify(translator, atLeastOnce()).create(any(AccountTransactionDto.class));
    }

     */


}