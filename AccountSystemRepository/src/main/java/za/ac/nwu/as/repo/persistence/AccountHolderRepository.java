package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountHolder;

import java.time.LocalDate;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

    @Query(value = "SELECT " +
            "       MEMBER_ID, " +
            "       MEMBER_NAME, " +
            "       BALANCE, " +
            "       CURRENCY, " +
            "       START_DATE" +
            "       FROM " +
            "           SVEN.ACCOUNT_HOLDER "+
            "       WHERE MEMBER_ID = :memberId ", nativeQuery = true)
    AccountHolder getAccountHolderByIDNativeQuery(int memberId);

    @Query(value = "SELECT " +
            "       at" +
            "       FROM " +
            "       AccountHolder at" +
            "       WHERE   at.memberName = :memberName ")
    AccountHolder getAccountHolderByName(String memberName);

    @Query(value = "UPDATE " +
            "       SVEN.ACCOUNT_HOLDER " +
            "       SET BALANCE = :newAccountBalance," +
            "       CURRENCY = :newAccountCurrency," +
            "       MEMBER_NAME = :newAccountName," +
            "       START_DATE = :newAccountCreationDate" +
            "       WHERE MEMBER_ID = :memberId", nativeQuery = true)
    AccountHolder updateAccountHolderByIDNativeQuery(String newAccountCurrency, int newAccountBalance, String newAccountName, LocalDate newAccountCreationDate);

    @Query(value = "UPDATE " +
            "       SVEN.ACCOUNT_HOLDER " +
            "       SET BALANCE = :newAccountBalance" +
            "       WHERE MEMBER_ID = :memberId", nativeQuery = true)
    AccountHolder subtractMilesByIDNativeQuery(int memberId, int newAccountBalance);

}
