package za.ac.nwu.as.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.translator.AccountHolderTranslator;
import za.ac.nwu.as.translator.AccountTypeTranslator;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountHolderFlowImplTest {

    @Mock
    private AccountHolderTranslator translator;

    @InjectMocks
    private CreateAccountHolderFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        // Write a test here
        when(translator.create(any(AccountHolderDto.class))).thenReturn(null);
        AccountHolderDto result = flow.create((new AccountHolderDto()));
        assertNull(result);
        verify(translator, atLeastOnce()).create(any(AccountHolderDto.class));
    }
}