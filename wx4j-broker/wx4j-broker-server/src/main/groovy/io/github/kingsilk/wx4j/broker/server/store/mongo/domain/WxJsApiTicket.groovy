package io.github.kingsilk.wx4j.broker.server.store.mongo.domain

import org.springframework.data.mongodb.core.index.Indexed

/**
 *
 */
class WxJsApiTicket extends Base {

    /**
     * 开放平台第三方授权的 appId。
     */
    String appId3rd;

    String appId;

    String jsApiTicket

    /**
     * 凭证过期时间，由获取时间+有效时间计算的
     */
    @Indexed(expireAfterSeconds = 0)
    Date expiresAt;

}
