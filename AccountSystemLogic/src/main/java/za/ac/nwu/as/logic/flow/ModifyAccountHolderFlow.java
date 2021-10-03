package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountHolderDto;
import java.time.LocalDate;

public interface ModifyAccountHolderFlow  {
    AccountHolderDto subtractMiles(int memberId, int balanced);

    AccountHolderDto updateAccountHolder(String memberName, int balance, String currency, LocalDate startDate);

    AccountHolderDto addMiles(int memberId, int balance);
}
