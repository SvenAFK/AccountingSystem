package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.logic.flow.ModifyAccountHolderFlow;
import za.ac.nwu.as.translator.AccountHolderTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyAccountHolderFlowImpl implements ModifyAccountHolderFlow {

    private final AccountHolderTranslator translator;

    @Autowired
    public ModifyAccountHolderFlowImpl(AccountHolderTranslator translator){
        this.translator = translator;
    }

    @Override
    public AccountHolderDto subtractMiles(Long memberId, Long balance) {
        AccountHolderDto account = new AccountHolderDto();
        account.setBalance(account.getBalance() - balance);
        return account;
    }

    @Override
    public AccountHolderDto addMiles(Long memberId, Long balance) {
        return null;
    }

    @Override
    public AccountHolderDto updateAccountHolder(String memberName, Long balance, String currency, LocalDate startDate) {
        return null;
    }
}
