package za.ac.nwu.as.web.sb.controller;

import org.junit.After;
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
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.logic.flow.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountHolderControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_HOLDER_CONTROLLER_URL = APP_URL + "/account-holder";

    @Mock
    private FetchAccountHolderFlow fetchAccountHolderFlow;

    @Mock
    private CreateAccountHolderFlow createAccountHolderFlow;

    @Mock
    private ModifyAccountHolderFlow modifyAccountHolderFlow;

    @InjectMocks
    private AccountHolderController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void create() throws Exception {
        String accountTypeToBeCreated = "{\"memberName\":\"NAME\",\"balance\":1000,\"currency\":\"MILES\",\"startDate\":[2020,1,1]},";
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"memberName\":\"NAME\",\"balance\":1000,\"currency\":\"MILES\",\"startDate\":[2020,1,1]}}";

        AccountHolderDto accountHolder = new AccountHolderDto("NAME", 1000,"MILES", LocalDate.parse("2020-01-01"));

        when(createAccountHolderFlow.create(eq(accountHolder))).then(returnsFirstArg());

        MvcResult mvcResult = mockMvc.perform(post(ACCOUNT_HOLDER_CONTROLLER_URL)
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(accountTypeToBeCreated)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        verify(createAccountHolderFlow, times(1)).create(eq(accountHolder));
        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }
/*
    @Test
    public void updateAccountHolder() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"memberName\":\"HOLDER\",\"balance\":1000,\"currency\":\"MILES\",\"startDate\":[2021,4,1]}}";

        AccountHolderDto accountHolder = new AccountHolderDto("HOLDER", 1000, "MILES",
                LocalDate.parse("2021-04-01"));

        when(modifyAccountHolderFlow.updateAccountHolder(anyInt(),anyString(), anyInt(), anyString(), any(LocalDate.class))).thenReturn(accountHolder);

        MvcResult mvcResult = mockMvc.perform(put((String.format("%s/%s", ACCOUNT_HOLDER_CONTROLLER_URL, "HOLDER")))
                        .param("newAccountHolderBalance", String.valueOf(1000))
                        .param("newAccountHolderCurrency", "MILES")
                        .param("newCreationDate", "2021-04-01")
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(modifyAccountHolderFlow, times(1)).updateAccountHolder(eq(120), eq("HOLDER"),eq(1000),
                eq("MILES"), eq(LocalDate.parse("2021-04-01")));
        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }
*/
    @Test
    public void getAll() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":[" +
                "{\"memberName\":\"HOLDER\",\"balance\":1000,\"currency\":\"MILES\",\"startDate\":[2021,4,1]}]}";
        List<AccountHolderDto> accountHolders = new ArrayList<>();
        accountHolders.add(new AccountHolderDto("HOLDER", 1000, "MILES", LocalDate.parse("2021-04-01")));
        /*accountHolders.add(new AccountHolderDto("PLAY", 1500, "ZAR",
                LocalDate.parse("2020-04-01")));*/

        when(fetchAccountHolderFlow.getAllAccountHolders()).thenReturn(accountHolders);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s", ACCOUNT_HOLDER_CONTROLLER_URL, "all")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(fetchAccountHolderFlow, times(1)).getAllAccountHolders();
        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }


/*
    @Test
    public void deleteAccountType() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"mnemonic\":\"PLAY\",\"accountTypeName\":\"Play account type\",\"creationDate\":[2021,4,1]}}";
        AccountTypeDto accountType = new AccountTypeDto("PLAY", "Play account type", LocalDate.parse("2021-04-01"));

        when(modifyAccountHolderFlow.deleteAccountType(anyString())).thenReturn(accountType);

        MvcResult mvcResult = mockMvc.perform(delete((String.format("%s/%s", ACCOUNT_TYPE_CONTROLLER_URL, "PLAY")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(modifyAccountHolderFlow, times(1)).deleteAccountType(eq("PLAY"));
        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }
*/
}