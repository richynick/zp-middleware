package com.richard.zptask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactDetails {

    private String transactionId;
    private String merchantId;
    private String bankReferenceId;
    private String status;
    private double amount;

}
