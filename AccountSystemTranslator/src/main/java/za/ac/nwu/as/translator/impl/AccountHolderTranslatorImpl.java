package za.ac.nwu.as.translator.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.AccountHolder;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.repo.persistence.AccountHolderRepository;
import za.ac.nwu.as.translator.AccountHolderTranslator;
import java.text.Format;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountHolderTranslatorImpl implements AccountHolderTranslator {

    private final AccountHolderRepository repo;

    public AccountHolderTranslatorImpl(AccountHolderRepository accountHolderRepository){
        this.repo = accountHolderRepository;
    }

    @Override
    public AccountHolder save(AccountHolder accountHolder) {
        try {
            return repo.save(accountHolder);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the Database", e);
        }
    }

    @Override
    public List<AccountHolder> getAllAccountHolders() {
        List<AccountHolder> accountHolders;
        try {
            accountHolders = new ArrayList<>(repo.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Unable to read to the Database", e);
        }
        return accountHolders;
    }

    @Override
    public AccountHolderDto create(AccountHolderDto accountHolderDto) {
        try {
            AccountHolder accountHolder = repo.save(accountHolderDto.getAccountHolder());
            return new AccountHolderDto(accountHolder);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the Database", e);
        }
    }

    @Override
    public AccountHolderDto updateAccountHolder(int memberId, String memberName, int newAccountBalance, String newAccountCurrency, LocalDate newAccountStartDate) {
        try {
            AccountHolder accountHolder = repo.updateAccountHolderByIDNativeQuery(memberId, memberName, newAccountBalance, newAccountCurrency, newAccountStartDate);
            return new AccountHolderDto(accountHolder);
        } catch (Exception e) {
            throw new RuntimeException("Unable to update the Database", e);
        }
    }

    @Override
    public AccountHolderDto addMiles(int memberId, int newAccountBalance){
        try {
            AccountHolder accountHolder = repo.getAccountHolderByIDNativeQuery(memberId);
            accountHolder.setBalance(accountHolder.getBalance() + newAccountBalance);
            repo.save(accountHolder);
            return new AccountHolderDto(accountHolder);
        } catch (Exception e) {
            throw new RuntimeException("Unable to add currency the Database", e);
        }
    }

    @Override
    public AccountHolderDto subtractMiles(int memberId, int newAccountBalance) {
        try {
            AccountHolder accountHolder = repo.subtractMilesByIDNativeQuery(memberId, newAccountBalance);
            return new AccountHolderDto(accountHolder);
        } catch (Exception e) {
            throw new RuntimeException("Unable to subtract currency the Database", e);
        }
    }

    @Override
    public AccountHolderDto getAccountHolderByIDNativeQuery(int memberId) {
        try {
            AccountHolder accountHolder = repo.getAccountHolderByIDNativeQuery(memberId);
            return new AccountHolderDto(accountHolder);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the Database", e);
        }
    }
}
