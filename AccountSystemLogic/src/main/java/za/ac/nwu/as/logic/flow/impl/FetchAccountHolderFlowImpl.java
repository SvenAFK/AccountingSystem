package za.ac.nwu.as.logic.flow.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.persistence.AccountHolder;
import za.ac.nwu.as.logic.flow.FetchAccountHolderFlow;
import za.ac.nwu.as.translator.AccountHolderTranslator;
import za.ac.nwu.as.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchAccountHolderFlowImpl implements FetchAccountHolderFlow {

    private AccountHolderTranslator translator;

    @Autowired
    public FetchAccountHolderFlowImpl(AccountHolderTranslator translator){
        this.translator = translator;
    }

    @Override
    public List<AccountHolderDto> getAllAccountHolders() {
        List<AccountHolderDto> accountHolderDtos = new ArrayList<>();
        for (AccountHolder accountHolder : translator.getAllAccountHolders()) {
            accountHolderDtos.add(new AccountHolderDto(accountHolder));
        }
        return accountHolderDtos;
    }

    @Override
    public AccountHolderDto getAccountHolderById(int memberId) {
        return translator.getAccountHolderByIDNativeQuery(memberId);
    }
}
