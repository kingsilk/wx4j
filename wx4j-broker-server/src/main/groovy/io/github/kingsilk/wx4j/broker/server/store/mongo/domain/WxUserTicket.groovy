package io.github.kingsilk.wx4j.broker.server.store.mongo.domain

import org.springframework.data.mongodb.core.index.Indexed

/**
 * 微信：网页授权access_token
 *
 * 业务主键：appId3rd，appId，openId，accessToken
 */
class WxUserTicket extends Base {

    /**
     * 开放平台第三方授权的 appId。
     */
    String appId3rd;

    /**
     * 微信应用。
     */
    String appId

    /**
     * 用户(人) 的 openId。
     */
    String openId;

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

}
