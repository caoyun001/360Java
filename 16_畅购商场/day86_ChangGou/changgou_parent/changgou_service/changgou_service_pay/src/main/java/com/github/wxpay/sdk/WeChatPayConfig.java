package com.github.wxpay.sdk;

import java.io.InputStream;

/**
 * 微信 支付 Java配置
 * 
 */
public class WeChatPayConfig extends WXPayConfig {



    /**
     * 微信公众账号或开放平台APP的唯一标识
     */
    String getAppID() {
        return "wx8397f8696b538317";
    }

    /**
     *商户号
     */
    String getMchID() {
        return "1473426802";
    }

    /**
     * 商户密钥
     */
    String getKey() {
        return "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb";
    }

    InputStream getCertStream() {
        return null;
    }

    IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }
            public DomainInfo getDomain(WXPayConfig config) {
                return new DomainInfo("api.mch.weixin.qq.com",true);
            }
        };
    }
}