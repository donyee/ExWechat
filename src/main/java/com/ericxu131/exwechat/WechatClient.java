package com.ericxu131.exwechat;

import com.ericxu131.exwechat.model.WechatMessageResult;
import com.ericxu131.exwechat.utils.WechatUtils;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author eric
 */
public class WechatClient {

    private static final Logger logger = LoggerFactory.getLogger(WechatClient.class);
    private final String appid, secret;
    private String accessToken;
    private Long accessTokenCreateTime;
    private int accessTokenExpiresIn = 0;

    public WechatClient(String appid, String secret) {
        this.appid = appid;
        this.secret = secret;
    }

    private String getAccessToken() {
        if (accessToken == null || new Date().getTime() > (accessTokenCreateTime + accessTokenExpiresIn)) {
            accessTokenCreateTime = new Date().getTime();
            Map result = WechatUtils.getAccessToken(appid, secret);
            accessToken = (String) result.get("access_token");
            accessTokenExpiresIn = ((Double) result.get("expires_in")).intValue();
        }
        return accessToken;
    }

    public WechatMessageResult send(String message, String toUser) {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource("https://api.weixin.qq.com/cgi-bin/message/custom/send");
        ClientResponse clientResponse = webResource
                .queryParam("access_token", getAccessToken())
                .post(ClientResponse.class, new Gson().toJson(new MassageBuilder("text").toUser(toUser).textContent(message).bulid()));

        if (clientResponse.getStatus() != 200) {
            throw new IllegalStateException("status error:" + clientResponse.getStatus());
        } else {
            return new Gson().fromJson(clientResponse.getEntity(String.class), WechatMessageResult.class);
        }
    }

    public class MassageBuilder {

        private final Map message = new HashMap();

        public MassageBuilder(String type) {
            message.put("msgtype", type);
        }

        public MassageBuilder toUser(String user) {
            message.put("touser", user);
            return this;
        }

        public MassageBuilder textContent(String content) {
            Map text = (Map) message.get("text");
            if (text == null) {
                text = new HashMap();
                message.put("text", text);
            }
            text.put("content", content);
            return this;
        }

        public Map bulid() {
            logger.debug("build message {}", message);
            return message;
        }

    }

}
