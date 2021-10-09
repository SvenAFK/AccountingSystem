package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.dto.AccountHolderDto;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.AccountHolder;
import java.time.LocalDate;
import java.util.List;

public interface AccountHolderTranslator {

    AccountHolder save(AccountHolder accountHolder);

    List<AccountHolder> getAllAccountHolders();

    AccountHolderDto create(AccountHolderDto accountHolder);

    AccountHolderDto updateAccountHolder(String memberName, int newAccountBalance, String newAccountCurrency, LocalDate newAccountStartDate);

    AccountHolderDto addMiles(int memberId, int newAccountBalance);

    AccountHolderDto subtractMiles(int memberId, int newAccountBalance);

    AccountHolderDto getAccountHolderByIDNativeQuery(int memberId);

}
