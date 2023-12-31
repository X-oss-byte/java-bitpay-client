/*
 * Copyright (c) 2019 BitPay
 */
package com.bitpay.sdk.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PolicyTest {
  @Test
  public void it_should_get_policy() {
    String expectedPolicy = "sin";

    Policy policy = new Policy();
    policy.setPolicy(expectedPolicy);

    String actualPolicy = policy.getPolicy();

    assertEquals(expectedPolicy, actualPolicy);
  }

  @Test
  public void it_should_get_method() {
    String expectedMethod = "requireSin";

    Policy policy = new Policy();
    policy.setMethod(expectedMethod);

    String actualMethod = policy.getMethod();

    assertEquals(expectedMethod, actualMethod);
  }

  @Test
  public void it_should_get_params() {
    List<String> expectedParams = new ArrayList<String>();
    String sin = "Tf1XQVBRPxVeQEQXUb7NTtcoB1qbAzGYBQ9";
    expectedParams.add(sin);

    Policy policy = new Policy();
    policy.setParams(expectedParams);

    List<String> actualParams = policy.getParams();

    assertEquals(expectedParams, actualParams);
  }
}
