package com.example.learning.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoqicheng on 2017/4/25.
 * 本机相关配置文件（主要和JWT相关）
 */
@Component
@ConfigurationProperties(prefix = "audience")
public class Audience {
    /**
     * 本机客户端ID   用作与其他客户机交互签发证明
     */
    private String clientId;
    /**
     * 本机base64的秘钥，暂时用于加密解密token
     */
    private String base64Secret;
    /**
     * 名称，以及定义的token过期时间
     */
    private String name;

    private Long expiresSecond;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBase64Secret() {
        return base64Secret;
    }

    public void setBase64Secret(String base64Secret) {
        this.base64Secret = base64Secret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getExpiresSecond() {
        return expiresSecond;
    }

    public void setExpiresSecond(Long expiresSecond) {
        this.expiresSecond = expiresSecond;
    }
}
