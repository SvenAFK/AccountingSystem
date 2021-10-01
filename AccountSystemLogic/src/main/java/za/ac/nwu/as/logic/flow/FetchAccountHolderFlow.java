package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountHolderDto;
import java.util.List;

public interface FetchAccountHolderFlow {

    List<AccountHolderDto> getAllAccountHolders();

    AccountHolderDto getAccountHolderById(int memberId);
}
