package com.richard.zptask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebhookResponse {
    private String transactionId;
    private String status;
    private String bankReferenceId;
}
