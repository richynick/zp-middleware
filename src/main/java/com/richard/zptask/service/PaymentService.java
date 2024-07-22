package com.richard.zptask.service;

import com.richard.zptask.dto.PaymentRequest;
import com.richard.zptask.dto.TransactionResponse;
import com.richard.zptask.dto.WebhookResponse;
import com.richard.zptask.model.Payment;
import com.richard.zptask.model.Transaction;

import java.util.Optional;

public interface PaymentService {
    TransactionResponse initiateTransaction(PaymentRequest payment);
    Optional<Transaction> getTransactionStatus(String transactionId);

    public Transaction processTransactionStatus(WebhookResponse webhookResponse);
}
