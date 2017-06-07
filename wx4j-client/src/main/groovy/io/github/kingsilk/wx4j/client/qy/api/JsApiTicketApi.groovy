package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi
import io.github.kingsilk.wx4j.client.qy.WxQyApi.BaseResp

/**
 *
 */
interface JsApiTicketApi extends WxQyApi {


    final String API_URL_getTicket = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket"
    final String API_URL_getWxCardTicket = "https://qyapi.weixin.qq.com/cgi-bin/ticket/get"

    // ----------------------------------------------
    /**
     * 获得jsapi_ticket
     */
    GetTicketResp getTicket(
            String access_token
    )

    static class GetTicketResp extends BaseResp {
        String ticket
        Integer expires_in
    }

    // ----------------------------------------------
    /**
     * 获得 api_ticket, 该 ticket 是用于调用微信卡券JS API的临时票据
     */
    GetWxCardTicketResp getWxCardTicket(
            String access_token
    )

    static class GetWxCardTicketResp extends BaseResp {
        String ticket
        Integer expires_in
    }
}
