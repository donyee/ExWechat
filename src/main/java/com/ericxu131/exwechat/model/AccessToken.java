package com.ericxu131.exwechat.model;

/**
 *
 * @author eric
 */
public class AccessToken {

    private final String token;
    private final Long expiresTimestemp;

    public AccessToken(String token, Long expiresTimestemp) {
        this.token = token;
        this.expiresTimestemp = expiresTimestemp;
    }

    public String getToken() {
        return token;
    }

    public Long getExpiresTimestemp() {
        return expiresTimestemp;
    }

}
