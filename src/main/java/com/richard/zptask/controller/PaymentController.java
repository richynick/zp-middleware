package com.richard.zptask.controller;

import com.richard.zptask.dto.PaymentRequest;
import com.richard.zptask.dto.TransactionResponse;
import com.richard.zptask.dto.WebhookResponse;
import com.richard.zptask.model.Transaction;
import com.richard.zptask.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<TransactionResponse> processPayment(@RequestBody PaymentRequest payment){
        TransactionResponse transaction = paymentService.initiateTransaction(payment);
        return ResponseEntity.ok(transaction);
    }
    @GetMapping("/status")
    public ResponseEntity<Optional<Transaction>> getTransactionStatus(@RequestBody String transactionId){
        Optional<Transaction> transaction = paymentService.getTransactionStatus(transactionId);
        return ResponseEntity.ok(transaction);
    }
    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook(WebhookResponse webhookResponse){
        paymentService.processTransactionStatus(webhookResponse);
        return ResponseEntity.ok("Webhook processed");
    }


}
