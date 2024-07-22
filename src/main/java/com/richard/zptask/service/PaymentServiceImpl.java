package com.richard.zptask.service;

import com.richard.zptask.dto.PaymentRequest;
import com.richard.zptask.dto.TransactDetails;
import com.richard.zptask.dto.TransactionResponse;
import com.richard.zptask.dto.WebhookResponse;
import com.richard.zptask.model.Transaction;
import com.richard.zptask.repository.TransactionRepository;
import com.richard.zptask.utility.TransactionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    public TransactionResponse initiateTransaction(PaymentRequest payment) {

        Transaction transaction = Transaction.builder()
                .amount(payment.getAmount())
                .status("pending")
                .currency(payment.getCurrency())
                .merchantId(TransactionUtility.generateMerchantId())
                .transactionId(TransactionUtility.generateTransactionId())
                .bankReferenceId(TransactionUtility.generateBankReferenceId())
                .build();
        Transaction savedTransaction = transactionRepository.save(transaction);

        return TransactionResponse.builder()
                .responseCode(TransactionUtility.TRANSACTION_PROCESSING)
                .responseMessage(TransactionUtility.TRANSACTION_MESSAGE)
                .transactionDetails(TransactDetails.builder()
                        .transactionId(savedTransaction.getTransactionId())
                        .amount(savedTransaction.getAmount())
                        .bankReferenceId(savedTransaction.getBankReferenceId())
                        .status("Pending")
                        .merchantId(savedTransaction.getMerchantId())
                        .build())
                .build();
    }

    @Override
    public Optional<Transaction> getTransactionStatus(String transactionId) {
        Transaction transactionById = transactionRepository.findByTransactionId(transactionId);
        return Optional.ofNullable(transactionById);
    }

    @Override
    public Transaction processTransactionStatus(WebhookResponse webhookResponse) {
        Transaction transaction = transactionRepository.findByTransactionId(webhookResponse.getTransactionId());
        if(transaction!=null){
            transaction.setStatus(webhookResponse.getStatus());
            transactionRepository.save(transaction);
        }
        return transaction;
    }
}
