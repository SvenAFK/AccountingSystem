package za.ac.nwu.as.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTransactionDto;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.as.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.as.translator.AccountTransactionDetailsTranslator;
import za.ac.nwu.as.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("createAccountTransactionFlowName")
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final AccountTransactionDetailsTranslator accountTransactionDetailsTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                            AccountTransactionDetailsTranslator accountTransactionDetailsTranslator,
                                            FetchAccountTypeFlow fetchAccountTypeFlow) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.accountTransactionDetailsTranslator = accountTransactionDetailsTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto) {

        if(LOGGER.isInfoEnabled()) {
            String outputForLogging = "null";
            if ((null != accountTransactionDto) && (null != accountTransactionDto.getDetails())) {
                outputForLogging = accountTransactionDto.getDetails().toString();
            }
            LOGGER.info("The input is {} and the Details is {}", accountTransactionDto, outputForLogging);
        }

        accountTransactionDto.setTransactionId(0);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Got AccountType for {} and the AccountTypeId is {}", accountTransactionDto.getAccountTypeMnemonic(), accountType.getAccountTypeId());
        }

        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        if (null != accountTransactionDto.getDetails()) {
            AccountTransactionDetails accountTransactionDetails = accountTransactionDto.getDetails().buildAccountTransactionDetails(createdAccountTransaction);
            accountTransactionDetailsTranslator.save(accountTransactionDetails);
        }
        AccountTransactionDto results = new AccountTransactionDto(createdAccountTransaction);
        //LOGGER.info("The return object is {}", results);
        LOGGER.warn("The return object is {}", results);
        return results;
    }
}
