package za.ac.nwu.as.web.sb.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.logic.flow.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountTransactionControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_TRANSACTION_CONTROLLER_URL = APP_URL + "/account-transaction";

    @Mock
    private FetchAccountTransactionFlow fetchAccountTransactionFlow;

    @Mock
    private CreateAccountTransactionFlow createAccountTransactionFlow;


    @InjectMocks
    private AccountTransactionController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void create() throws Exception {
        String accountTransactionToBeCreated = "{\"transactionId\":2314,\"accountTypeMnemonic\":\"HOLDER\",\"memberId\":1234,\"amount\":1500,\"transactionDate\":[2020,1,1],\"details\":null}}";
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"transactionId\":2314,\"accountTypeMnemonic\":\"HOLDER\",\"memberId\":1234,\"amount\":1500,\"transactionDate\":[2020,1,1],\"details\":null}}";

        AccountTransactionDto accountTransaction = new AccountTransactionDto(2314, "HOLDER",1234,1500, LocalDate.parse("2020-01-01"),null);

        when(createAccountTransactionFlow.create(eq(accountTransaction))).then(returnsFirstArg());

        MvcResult mvcResult = mockMvc.perform(post(ACCOUNT_TRANSACTION_CONTROLLER_URL)
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(accountTransactionToBeCreated)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        verify(createAccountTransactionFlow, times(1)).create(eq(accountTransaction));
        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getAll() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":[" +
                "{\"transactionId\":2314,\"accountTypeMnemonic\":\"HOLDER\",\"memberId\":1234,\"amount\":1500,\"transactionDate\":[2020,1,1],\"details\":null}]}";
        List<AccountTransactionDto> accountTransaction = new ArrayList<>();
        accountTransaction.add(new AccountTransactionDto(2314, "HOLDER",1234,1500, LocalDate.parse("2020-01-01")));

        when(fetchAccountTransactionFlow.getAllAccountTransactions()).thenReturn(accountTransaction);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s", ACCOUNT_TRANSACTION_CONTROLLER_URL, "all")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(fetchAccountTransactionFlow, times(1)).getAllAccountTransactions();
        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

}