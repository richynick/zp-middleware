package com.richard.zptask.utility;

import java.util.Random;

public class TransactionUtility {

    public static final String TRANSACTION_PROCESSING = "002";
    public static final String TRANSACTION_MESSAGE = "Transaction is being processing";

    public static String generateBankReferenceId() {
        return "BANK" + new Random().nextInt(100000);
    }

    public static String generateTransactionId(){
        return "txn_" + System.currentTimeMillis();
    }

    public static String generateMerchantId(){
        return "MERCH" + new Random().nextInt(100000);
    }
}
