package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi
import io.github.kingsilk.wx4j.client.qy.WxQyApi.BaseResp

/**
 *
 */
interface JsApiTicketApi extends WxQyApi {

    String API_URL_getTicket = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket"

    GetTicketResp getTicket(String access_token)

    static class GetTicketResp extends BaseResp {
        String ticket
        Integer expires_in
    }
}
