package io.github.kingsilk.wx4j.client.mp.api

import io.github.kingsilk.wx4j.client.mp.WxMpApi

import static WxMpApi.BaseResp

/**
 *
 */
interface JsApiTicketApi extends WxMpApi {

    final String API_URL_getTicket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket"

    // ----------------------------------------------
    GetTicketResp getTicket(String access_token)

    static class GetTicketResp extends BaseResp {
        String ticket
        int expires_in
    }
}
