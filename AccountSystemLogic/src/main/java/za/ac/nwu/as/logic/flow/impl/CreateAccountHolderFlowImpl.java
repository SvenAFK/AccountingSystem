package za.ac.nwu.as.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.logic.flow.CreateAccountHolderFlow;
import za.ac.nwu.as.translator.AccountHolderTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountHolderFlowName")
public class CreateAccountHolderFlowImpl implements CreateAccountHolderFlow {

    private final AccountHolderTranslator accountHolderTranslator;

    public CreateAccountHolderFlowImpl(AccountHolderTranslator accountHolderTranslator) {
        this.accountHolderTranslator = accountHolderTranslator;
    }

    @Override
    public AccountHolderDto create(AccountHolderDto accountHolder) {
        if (null == accountHolder.getStartDate()){
            accountHolder.setStartDate(LocalDate.now());
        }
        //accountHolderTranslator.create(accountHolder);
        return accountHolderTranslator.create(accountHolder);
    }
}
