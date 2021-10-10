package za.ac.nwu.as.domain.persistence;

import org.junit.Test;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import static org.junit.Assert.*;

public class AccountTypeTest {

    @Test
    public void getAccountTypeId() {
        AccountType accountType = new AccountType(12,"mnemonic","ccountTypeName",LocalDate.now());
        assertNotNull(accountType.getAccountTypeId());
    }

    @Test
    public void getMnemonic() {
        AccountType accountType = new AccountType();
        assertNull(accountType.getMnemonic());
    }

    @Test
    public void getAccountTypeName() {
        AccountType accountType = new AccountType();
        assertNull(accountType.getAccountTypeName());
    }

    @Test
    public void getCreationDate() {
        AccountType accountType = new AccountType();
        assertNull(accountType.getCreationDate());
    }

    @Test
    public void getAccountTransactions() {
        AccountType accountType = new AccountType();
        assertNull(accountType.getAccountTransactions());
    }

    @Test
    public void setAccountTransactions() {

        Set<AccountTransaction> accountTransactions = new Set<AccountTransaction>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<AccountTransaction> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(AccountTransaction accountTransaction) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends AccountTransaction> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        AccountType accountType = new AccountType();
        AccountType accountType1 = new AccountType(123,"accountMnemonic","AccountTypeName",LocalDate.now());
        accountType1.toString();
        accountType1.equals(accountType);
        accountType1.hashCode();
        accountType.setAccountTransactions(accountTransactions);
    }

    @Test
    public void setAccountTypeId() {
        AccountType accountType = new AccountType();
        accountType.setAccountTypeId(123);
    }

    @Test
    public void setMnemonic() {
        AccountType accountType = new AccountType();
        accountType.setMnemonic("MILES");
    }

    @Test
    public void setAccountTypeName() {
        AccountType accountType = new AccountType();
        accountType.setAccountTypeName("accountTypeName");
    }

    @Test
    public void setCreationDate() {
        AccountType accountType = new AccountType();
        accountType.setCreationDate(LocalDate.now());
    }

}