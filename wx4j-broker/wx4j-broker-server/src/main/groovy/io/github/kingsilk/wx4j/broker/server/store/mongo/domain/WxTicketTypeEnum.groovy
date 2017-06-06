package io.github.kingsilk.wx4j.broker.server.store.mongo.domain;

/**
 * 微信号类型。
 */
public enum WxTicketTypeEnum {

    SELF("SELF", "公众号自身获取Access Token"),
    SELF_USER("USER", "公众号自身获取用户授权的 User Access Token "),
    PROXY("PROXY", "公众号第三方平台代替授权方获取Access Token"),
    PROXY_USER("PROXY", "公众号第三方平台代替授权方获取 User 授权的 Access Token");


    final String code;
    final String desp;

    WxTicketTypeEnum(String code, String desp) {
        this.code = code;
        this.desp = desp;
    }

}
