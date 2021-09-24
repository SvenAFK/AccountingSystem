package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.persistence.AccountHolder;

import java.util.List;

public interface AccountHolderTranslator {

    AccountHolder save(AccountHolder accountHolder);

    List<AccountHolder> getAllAccountHolders();

    AccountHolder getAccountHolderByPk(Long memberId);

    AccountHolderDto create(AccountHolderDto accountHolder);

}
