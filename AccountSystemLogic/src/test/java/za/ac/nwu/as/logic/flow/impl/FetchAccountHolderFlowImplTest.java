package za.ac.nwu.as.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.persistence.AccountHolder;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FetchAccountHolderFlowImplTest {

    private FetchAccountHolderFlowImpl classToTest;


    @Before
    public void setUp() throws Exception {
        classToTest = new FetchAccountHolderFlowImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        classToTest = null;
    }

    @Test
    public void getAllAccountHolders() {

    }

    @Test
    public void getAccountHolderById() {
    }
}