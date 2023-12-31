/*
 * Copyright (c) 2019 BitPay.
 * All rights reserved.
 */

package com.bitpay.sdk.exceptions;

/**
 * Exception which is extended by other exceptions related with Payout Recipient.
 *
 * @see com.bitpay.sdk.exceptions.PayoutRecipientCancellationException
 * @see com.bitpay.sdk.exceptions.PayoutRecipientCreationException
 * @see com.bitpay.sdk.exceptions.PayoutRecipientUpdateException
 * @see com.bitpay.sdk.exceptions.PayoutRecipientNotificationException
 * @see com.bitpay.sdk.exceptions.PayoutRecipientQueryException
 *
 * @see <a href="https://bitpay.readme.io/reference/error-codes">Rest API Error Codes</a>
 */
public class PayoutRecipientException extends BitPayException {
    /**
     * Construct the PayoutRecipientException.
     *
     * @param status  String [optional] The Exception code to throw.
     * @param message String [optional] The Exception message to throw.
     */
    public PayoutRecipientException(
        String status,
        String message
    ) {
        super(status, buildMessage(message));
    }

    private static String buildMessage(String message) {
        String bitPayMessage = "An unexpected error occurred while trying to manage the payout recipient";
        String bitPayCode = "BITPAY-PAYOUT-RECIPIENT-GENERIC";

        if (message.isEmpty() || !message.contains("BITPAY-")) {
            message = bitPayCode + ": " + bitPayMessage + " -> " + message;
        }

        return message;
    }
}
