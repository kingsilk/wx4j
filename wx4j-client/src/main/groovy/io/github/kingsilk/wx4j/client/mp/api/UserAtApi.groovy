package io.github.kingsilk.wx4j.client.mp.api

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.WxMpApi
import io.github.kingsilk.wx4j.client.mp.WxMpApi.BaseResp

/**
 * 获取 用户授权的 access_token
 */
@CompileStatic
interface UserAtApi extends WxMpApi {

    final String API_URL_createAuthUrl = "https://open.weixin.qq.com/connect/oauth2/authorize"
    final String API_URL_createScanAuthUrl = "https://open.weixin.qq.com/connect/qrconnect"
    final String API_URL_isValid = "https://api.weixin.qq.com/sns/auth"
    final String API_URL_getUserAt = "https://api.weixin.qq.com/sns/oauth2/access_token"
    final String API_URL_refresh = "https://api.weixin.qq.com/sns/oauth2/refresh_token"

    // ----------------------------------------------
    /**
     * 在微信APP以外，通过微信扫码登录相关API
     *
     * @param scope 应用授权作用域。
     *      snsapi_base     - 不弹出授权页面，直接跳转，只能获取用户openid
     *      snsapi_userinfo - 会弹出授权页面，可通过openid拿到昵称、性别、所在地。无需用户关注微信公众号
     *      snsapi_login    -
     *
     * @param state 最多128字节
     */
    String createScanAuthUrl(
            String appid,
            String redirect_uri,
            String scope,
            String state
    )

    // ----------------------------------------------
    /**
     * 在微信APP内部，通过用户点击授权按钮登录。
     *
     * @param scope 应用授权作用域。
     *      snsapi_base     - 不弹出授权页面，直接跳转，只能获取用户openid
     *      snsapi_userinfo - 会弹出授权页面，可通过openid拿到昵称、性别、所在地。无需用户关注微信公众号
     *
     * @param state 最多128字节
     */
    String createAuthUrl(
            String appid,
            String redirect_uri,
            String scope,
            String state
    )

    // ----------------------------------------------
    IsValidResp isValid(
            String access_token,
            String openid
    )

    static class IsValidResp extends BaseResp {
    }

    // ----------------------------------------------
    RefreshResp refresh(
            String appid,
            String refresh_token
    )

    static class RefreshResp extends BaseResp {
        /**
         * 网页授权接口调用凭证
         */
        String access_token

        /**
         * access_token接口调用凭证超时时间，单位（秒）
         */
        int expires_in

        /**
         * 用户刷新access_token
         */
        String refresh_token

        /**
         * 用户唯一标识
         */
        String openid

        /**
         * 用户授权的作用域，使用逗号（,）分隔
         */
        String scope
    }

    // ----------------------------------------------
    /**
     * 通过 code 换取用户级别的 access token。
     */
    GetUserAtResp getUserAt(
            String appid,
            String secret,
            String code
    )

    static class GetUserAtResp extends BaseResp {
        String access_token
        Integer expires_in
        String refresh_token
        String openid
        String scope
    }

}
