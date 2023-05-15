/*
 * Copyright (c) 2019 BitPay.
 * All rights reserved.
 */

package com.bitpay.sdk.exceptions;

/**
 * <p>
 * Exception thrown for a PUT when the Subscription cannot be updated.
 * </p>
 * <ul>
 *   <li>First two digits: HTTP method</li>
 *   <li>Second two digits: Resource</li>
 *   <li>Final two digits: Error</li>
 * </ul>
 * <p>HTTP method digits for this class: 03</p>
 * <p>Resource digits for the this class: 00</p>
 * <p>Error digits for this class:</p>
 * <ul>
 *     <li>00 - Generic server error</li>
 *     <li>01 - Resource not found</li>
 *     <li>02 - Invalid parameters</li>
 *     <li>03 - Missing parameters</li>
 * </ul>
 * <pre>
 * eg 030002
 * </pre>
 *
 * @see <a href="https://bitpay.readme.io/reference/error-codes">Rest API Error Codes</a>
 */
public class SubscriptionUpdateException extends SubscriptionException {
    /**
     * Construct the SubscriptionUpdateException.
     *
     * @param status String [optional] The Exception code to throw.
     * @param message String [optional] The Exception message to throw.
     */
    public SubscriptionUpdateException(
        String status,
        String message
    ) {
        super(status, buildMessage(message));
    }

    private static String buildMessage(String message) {
        String bitPayMessage = "Failed to update subscription";
        String bitPayCode = "BITPAY-SUBSCRIPTION-UPDATE";

        message = bitPayCode + ": " + bitPayMessage + " -> " + message;

        return message;
    }
}
