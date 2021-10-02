package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.AccountType;
import java.time.LocalDate;

public interface ModifyAccountTypeFlow {
    void deleteAccountType(String mnemonic);

    AccountTypeDto updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newCreationDate);

}
