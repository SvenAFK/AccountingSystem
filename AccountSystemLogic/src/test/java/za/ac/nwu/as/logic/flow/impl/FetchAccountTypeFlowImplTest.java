package za.ac.nwu.as.logic.flow.impl;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FetchAccountTypeFlowImplTest {

    private FetchAccountTypeFlowImpl classToTest;

    @Before
    public void setUp() throws Exception {
        classToTest = new FetchAccountTypeFlowImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        classToTest = null;
    }

    //@Ignore
    @Test
    public void methodToTest() {
        assertTrue(classToTest.methodToTest());
    }

    @Test
    public void getAllAccountTypes() {

    }
}