package za.ac.nwu.as.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.as.translator.AccountTransactionTranslator;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow {

    private AccountTransactionTranslator translator;

    public FetchAccountTransactionFlowImpl(AccountTransactionTranslator translator) { this.translator = translator;}

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions() {
        return translator.getAllAccountTransactions();
    }


    @Override
    public AccountTransactionDto getAccountTransactionById(int transactionId) {
        return translator.getAccountTransByIDNativeQuery(transactionId);
    }
}
