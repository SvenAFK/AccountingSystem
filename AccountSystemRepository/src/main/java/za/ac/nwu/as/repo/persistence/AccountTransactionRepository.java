package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    @Query(value = "SELECT " +
            "       ACCOUNT_TX_ID, " +
            "       ACCOUNT_TYPE_ID, " +
            "       MEMBER_ID, " +
            "       AMOUNT, " +
            "       TX_DATE" +
            "       FROM " +
            "       SVEN.ACCOUNT_TX "+
            "       WHERE ACCOUNT_TX_ID = :transactionId ", nativeQuery = true)
    AccountTransaction getAccountTransByIDNativeQuery(int transactionId);

}
