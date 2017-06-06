package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi
import io.github.kingsilk.wx4j.client.qy.WxQyApi.BaseResp

/**
 *
 */
interface AppAtApi extends WxQyApi {

    String API_URI_getAppAt = "https://qyapi.weixin.qq.com/cgi-bin/gettoken"

    GetTicketResp getAppAt(
            String corpid,
            String corpsecret
    )

    static class GetTicketResp extends BaseResp {
        String ticket
        Integer expires_in
    }
}
