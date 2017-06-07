package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi
import io.github.kingsilk.wx4j.client.qy.WxQyApi.BaseResp

/**
 * 在微信APP内部登录时，认证授权相关API。
 */
interface UserAtApi extends WxQyApi {

    final String API_URL_createAuthUrl = "https://open.weixin.qq.com/connect/oauth2/authorize"
    final String API_URL_getUserAt = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo"

    // ----------------------------------------------
    /**
     * 企业获取code
     */
    String createAuthUrl(
            String appid,
            String redirect_uri,
            String response_type,
            String scope,
            String agentid,
            String state
    )

    // ----------------------------------------------

    /**
     * 根据code获取成员信息
     */
    GetUserAtResp getUserAt(
            String access_token,
            String code
    )

    static class GetUserAtResp extends BaseResp {

        // 非企业成员授权时返回
        String OpenId

        // 企业成员授权时返回
        String UserId
        String DeviceId
        String user_ticket
        Integer expires_in
    }

}
