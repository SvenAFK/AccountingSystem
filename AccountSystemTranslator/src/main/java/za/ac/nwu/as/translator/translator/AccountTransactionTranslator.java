package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.persistence.AccountTransaction;

import java.util.List;

public interface AccountTransactionTranslator {

    AccountTransaction save(AccountTransaction accountTransaction);

    List<AccountTransaction> getAllAccountTransactions();

    AccountTransaction getAccountTransactionByPk(Long transactionId);
}
