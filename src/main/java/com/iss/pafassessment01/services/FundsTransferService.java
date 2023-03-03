package com.iss.pafassessment01.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iss.pafassessment01.exception.TransferException;
import com.iss.pafassessment01.models.Account;
import com.iss.pafassessment01.models.Transaction;
import com.iss.pafassessment01.models.TransactionResult;
import com.iss.pafassessment01.repositories.AccountsRepository;

import org.springframework.transaction.annotation.Transactional;


@Service
public class FundsTransferService {

    @Autowired
    private AccountsRepository accRepo;

    private Account acc;

    @Transactional(rollbackFor = TransferException.class)
    public TransactionResult createTransaction(Transaction trans) throws TransferException{
        String transId= UUID.randomUUID().toString()
            .substring(0, 8);
        trans.setTransactionId(transId);

        if(trans.getAmount().compareTo(acc.getBalance()) > 0){
            throw new TransferException();
        }
        if(trans.getFromAccount().equals(trans.getToAccount())){
            throw new TransferException();
        }
        accRepo.updateAcc(acc, transId);
        TransactionResult r = new TransactionResult();
        return r;
    }
    
}
