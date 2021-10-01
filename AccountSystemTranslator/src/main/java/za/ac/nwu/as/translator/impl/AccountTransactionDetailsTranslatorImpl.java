package za.ac.nwu.as.translator.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.as.repo.persistence.AccountTransactionDetailsRepository;
import za.ac.nwu.as.translator.AccountTransactionDetailsTranslator;

@Component
public class AccountTransactionDetailsTranslatorImpl implements AccountTransactionDetailsTranslator {

    private final AccountTransactionDetailsRepository repo;

    public AccountTransactionDetailsTranslatorImpl(AccountTransactionDetailsRepository accountTransactionDetailsRepository) {
        this.repo = accountTransactionDetailsRepository;
    }

    @Override
    public AccountTransactionDetails save(AccountTransactionDetails accountTransactionDetails) {
        try {
            return repo.save(accountTransactionDetails);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the Database", e);
        }
    }
}
