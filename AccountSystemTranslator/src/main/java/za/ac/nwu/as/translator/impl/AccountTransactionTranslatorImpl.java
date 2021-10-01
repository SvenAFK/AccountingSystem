package za.ac.nwu.as.translator.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.AccountHolder;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.as.translator.AccountTransactionTranslator;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository repo;

    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository){
        this.repo = accountTransactionRepository;
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction) {
        try {
            return repo.save(accountTransaction);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the Database", e);
        }
    }

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions() {
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        try {
            for (AccountTransaction accountTransaction: repo.findAll()) {
                accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the Database", e);
        }
        return accountTransactionDtos;

                /*List<AccountTransaction> accountTransactions;
        try {
            accountTransactions = new ArrayList<>(repo.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Unable to read to the Database", e);
        }
        return accountTransactions;
         */
    }

    /*
    @Override
    public AccountTransaction getAccountTransactionByPk(int transactionId) {
        try {
            Long value = Long.valueOf(transactionId);
            return repo.findById(value).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read to the Database", e);
        }
    }
*/

    @Override
    public AccountTransactionDto getAccountTransByIDNativeQuery(int transactionId) {
        try {
            AccountTransaction accountTransaction = repo.getAccountTransByIDNativeQuery(transactionId);
            return new AccountTransactionDto(accountTransaction);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the Database", e);
        }
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto) {
        try {
            AccountTransaction accountTransaction = repo.save(accountTransactionDto.getAccountTransaction());
            return new AccountTransactionDto(accountTransaction);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the Database", e);
        }
    }
}
