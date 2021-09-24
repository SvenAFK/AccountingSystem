package za.ac.nwu.as.translator.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.persistence.AccountHolder;
import za.ac.nwu.as.repo.persistence.AccountHolderRepository;
import za.ac.nwu.as.translator.AccountHolderTranslator;

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
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public List<AccountHolder> getAllAccountHolders() {
        List<AccountHolder> accountHolders;
        try {
            accountHolders = new ArrayList<>(repo.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Unable to read to the DB", e);
        }
        return accountHolders;
    }

    @Override
    public AccountHolder getAccountHolderByPk(Long memberId) {
        try {
            return repo.findById(memberId).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read to the DB", e);
        }
    }

    @Override
    public AccountHolderDto create(AccountHolderDto accountHolderDto) {
        try {
            AccountHolder accountHolder = repo.save(accountHolderDto.getAccountHolder());
            return new AccountHolderDto(accountHolder);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}
