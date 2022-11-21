package com.bitpay.sdk;

import com.bitpay.sdk.model.Facade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Objects;

/**
 * The type Config.
 */
public class Config {

    /**
     * Test Url.
     */
    public static final String TEST_URL = "https://test.bitpay.com/";
    /**
     * Production Url.
     */
    public static final String PROD_URL = "https://bitpay.com/";

    /**
     * BitPay Api Version.
     */
    public static final String BITPAY_API_VERSION = "2.0.0";

    /**
     * BitPay Plugin Info Version.
     */
    public static final String BITPAY_PLUGIN_INFO = "BitPay_Java_Client_v8.5.2208";
    /**
     * BitPay Api Frame.
     */
    public static final String BITPAY_API_FRAME = "std";
    /**
     * BitPay Api Frame Version.
     */
    public static final String BITPAY_API_FRAME_VERSION = "1.0.0";

    private static final String API_TOKENS_KEY = "ApiTokens";

    private Environment environment;
    private JsonNode envConfig;

    /**
     * Instantiates a new Config.
     */
    public Config() {
    }

    /**
     * Gets environment.
     *
     * There are two environments available for merchants to use the following API.
     * To access these APIs, merchants need to combine the base URL + endpoint and make sure to have API credentials
     * for the corresponding environments.
     *
     * @return the environment
     */
    @JsonIgnore
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * Sets environment.
     *
     * There are two environments available for merchants to use the following API.
     * To access these APIs, merchants need to combine the base URL + endpoint and make sure to have API credentials
     * for the corresponding environments.
     *
     * @param environment the environment
     */
    @JsonProperty("Environment")
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * Gets config for specific environment.
     *
     * @see <a href="https://github.com/bitpay/java-bitpay-client/blob/master/GUIDE.md#handling-your-client-private-key">
     *     Example of env config as JSON
     *     </a>
     *
     * @param env the env
     * @return the env config
     */
    @JsonIgnore
    public JsonNode getEnvConfig(Environment env) {
        return envConfig.path(env.toString());
    }

    /**
     * Sets config for specific environment.
     *
     * @see <a href="https://github.com/bitpay/java-bitpay-client/blob/master/GUIDE.md#handling-your-client-private-key">
     *     Example of env config as JSON
     *     </a>
     *
     * @param envConfig the env config
     */
    @JsonProperty("EnvConfig")
    public void setEnvConfig(JsonNode envConfig) {
        this.envConfig = envConfig;
    }

    public ObjectNode getApiTokens() {
        ObjectNode envConfig = (ObjectNode) this.getEnvConfig(this.getEnvironment());
        ObjectNode apiTokens = null;
        apiTokens = (ObjectNode) envConfig.get(API_TOKENS_KEY);
        if (Objects.isNull(apiTokens)) {
            apiTokens = (ObjectNode) JsonNodeFactory.instance.objectNode();
            envConfig.put(API_TOKENS_KEY, apiTokens);
        }

        return apiTokens;
    }

    void addApiToken(Facade facade, String value) {
        getApiTokens().put(facade.toString(), value);
    }
}