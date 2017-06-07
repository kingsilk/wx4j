package io.github.kingsilk.wx4j.broker.server.store.mongo.domain

import org.springframework.data.mongodb.core.index.Indexed

/**
 * 微信：普通access_token
 *
 * 业务主键：appId3rd,appId,accessToken
 */
class WxAppTicket extends Base {

    /**
     * 开放平台第三方授权的 appId。
     */
    String appId3rd;

    /**
     * 微信应用。
     */
    String appId

    /**
     * 过期时间。
     * <p>
     * 获取到 access_token 时，由系统时间 + expiresIn 得到。
     */
    @Indexed(expireAfterSeconds = 0)
    Date expiresAt;

    /**
     * 获取到的凭证。
     */
    @Indexed
    String accessToken;

    /**
     * 凭证有效时间，单位：秒
     */
    Integer expiresIn;

    /**
     * 刷新 Token.
     */
    String refreshToken;

    /**
     * scopes
     */
    Set<String> scopes = new LinkedHashSet<>();
//
//
//    static enum WxTicketTypeEnum {
//
//        /** 公众号自身获取Access Token */
//        SELF,
//
//        /** 公众号自身获取用户授权的 User Access Token */
//                SELF_USER,
//
//        /** 公众号第三方平台代替授权方获取Access Token */
//                PROXY,
//
//        /** 公众号第三方平台代替授权方获取 User 授权的 Access Token */
//                PROXY_USER
//    }
}
