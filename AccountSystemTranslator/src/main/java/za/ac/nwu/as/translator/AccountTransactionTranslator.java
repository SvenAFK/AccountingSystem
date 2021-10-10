package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import java.util.List;

public interface AccountTransactionTranslator {

    AccountTransaction save(AccountTransaction accountTransaction);

    List<AccountTransactionDto> getAllAccountTransactions();

    AccountTransactionDto create(AccountTransactionDto accountTransaction);

    AccountTransactionDto getAccountTransByIDNativeQuery(int transactionId);
}
