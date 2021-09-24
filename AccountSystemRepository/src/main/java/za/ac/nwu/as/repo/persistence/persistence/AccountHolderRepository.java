package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountHolder;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}
