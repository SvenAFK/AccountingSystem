package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_HOLDER", schema = "C##HEINKE")
public class AccountHolder implements Serializable {

    private static final long serialVersionUID = -6020840492390503972L;
    private Long memberId;
    private String memberName;
    private Long balance;
    private String currency;
    private LocalDate startDate;

    //private Set<AccountTransaction> accountTransactions;

    public AccountHolder() {
    }

    public AccountHolder(Long memberId, String memberName, Long balance, String currency, LocalDate startDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.balance = balance;
        this.currency = currency;
        this.startDate = startDate;
    }

    public AccountHolder(String memberName, Long balance, String currency, LocalDate startDate) {
        this.memberName = memberName;
        this.balance = balance;
        this.currency = currency;
        this.startDate = startDate;
    }

    @Id
    @SequenceGenerator(name = "NWU_GENERIC_SEQ", sequenceName = "HR.NWU_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NWU_GENERIC_SEQ")

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    @Column(name = "MEMBER_NAME")
    public String getMemberName() {
        return memberName;
    }

    @Column(name = "BALANCE")
    public Long getBalance() {
        return balance;
    }

    @Column(name = "CURRENCY")
    public String getCurrency() {
        return currency;
    }

    @Column(name = "START_DATE")
    public LocalDate getStartDate() {
        return startDate;
    }

    //@OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "memberId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    /*public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }*/

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /*public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountHolder that = (AccountHolder) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(memberName, that.memberName) && Objects.equals(balance, that.balance) && Objects.equals(currency, that.currency) && Objects.equals(startDate, that.startDate);/* && Objects.equals(accountTransactions, that.accountTransactions));*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberName, balance, currency, startDate/*, accountTransactions*/);
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", startDate=" + startDate +
                ", accountTransactions=" + /*accountTransactions +*/
                '}';
    }
}
