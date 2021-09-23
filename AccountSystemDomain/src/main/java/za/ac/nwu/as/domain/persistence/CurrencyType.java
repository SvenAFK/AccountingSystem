package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CURRENCY_TYPE", schema = "SVEN")
public class CurrencyType {

    private Long currencyTypeId;
    private String currencyName;

    private Set<MemberInfo> memberInfo;

    public CurrencyType() {
    }

    public CurrencyType(Long currencyTypeId, String currencyName, Set<MemberInfo> memberIno) {
        this.currencyTypeId = currencyTypeId;
        this.currencyName = currencyName;
        this.memberInfo = memberIno;
    }

    public CurrencyType(Long currencyTypeId, String currencyName) {
        this.currencyTypeId = currencyTypeId;
        this.currencyName = currencyName;
    }

    @Id
    @SequenceGenerator(name = "NWU_GENERIC_SEQ", sequenceName = "HR.NWU_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NWU_GENERIC_SEQ")

    @Column(name = "CURRENCY_TYPE_ID")
    public Long getCurrencyTypeId() {
        return currencyTypeId;
    }

    @Column(name = "CURRENCY_NAME")
    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyTypeId(Long currencyTypeId) {
        this.currencyTypeId = currencyTypeId;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyType that = (CurrencyType) o;
        return Objects.equals(currencyTypeId, that.currencyTypeId) && Objects.equals(currencyName, that.currencyName) && Objects.equals(memberInfo, that.memberInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyTypeId, currencyName, memberInfo);
    }

    @Override
    public String toString() {
        return "CurrencyType{" +
                "currencyTypeId=" + currencyTypeId +
                ", currencyName='" + currencyName + '\'' +
                ", memberIno=" + memberInfo +
                '}';
    }

}
