package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "MEMBER_INFO", schema = "SVEN")
public class MemberInfo {

    private Long memberId;
    private AccountType accountType;
    private CurrencyType currencyType;
    private String memberName;
    private String memberSurname;
    private LocalDate joinDate;

    public MemberInfo() {
    }

    public MemberInfo(Long memberId, AccountType accountType, CurrencyType currencyType, String memberName, String memberSurname, LocalDate joinDate) {
        this.memberId = memberId;
        this.accountType = accountType;
        this.currencyType = currencyType;
        this.memberName = memberName;
        this.memberSurname = memberSurname;
        this.joinDate = joinDate;
    }

    @Id
    @SequenceGenerator(name = "NWU_GENERIC_SEQ", sequenceName = "HR.NWU_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NWU_GENERIC_SEQ")

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_TYPE_ID")
    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    @Column(name = "MEMBER_NAME")
    public String getMemberName() {
        return memberName;
    }

    @Column(name = "MEMBER_SURNAME")
    public String getMemberSurname() {
        return memberSurname;
    }

    @Column(name = "JOIN_DATE")
    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberSurname(String memberSurname) {
        this.memberSurname = memberSurname;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberInfo that = (MemberInfo) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(accountType, that.accountType) && Objects.equals(currencyType, that.currencyType) && Objects.equals(memberName, that.memberName) && Objects.equals(memberSurname, that.memberSurname) && Objects.equals(joinDate, that.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, accountType, currencyType, memberName, memberSurname, joinDate);
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "memberId=" + memberId +
                ", accountType=" + accountType +
                ", currencyType=" + currencyType +
                ", memberName='" + memberName + '\'' +
                ", memberSurname='" + memberSurname + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }
}
