package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountHolderDto;

import java.time.LocalDate;

public interface ModifyAccountHolderFlow  {
    AccountHolderDto subtractMiles(Long memberId, Long balanced);

    AccountHolderDto updateAccountHolder(String memberName, Long balance, String currency, LocalDate startDate);

    AccountHolderDto addMiles(Long memberId, Long balance);
}
