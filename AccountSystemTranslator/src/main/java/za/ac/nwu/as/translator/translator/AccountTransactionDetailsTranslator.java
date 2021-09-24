package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.persistence.AccountTransactionDetails;

public interface AccountTransactionDetailsTranslator {
    AccountTransactionDetails save(AccountTransactionDetails accountTransactionDetails);
}
