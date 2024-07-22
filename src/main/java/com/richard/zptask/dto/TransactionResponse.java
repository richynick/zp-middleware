package com.richard.zptask.dto;

import com.richard.zptask.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {
    private String responseCode;
    private String responseMessage;
    private TransactDetails transactionDetails;
}
