package io.github.kingsilk.wx4j.client.mp.api

import io.github.kingsilk.wx4j.client.mp.WxMpApi
import io.github.kingsilk.wx4j.client.mp.WxMpApi.BaseResp

/**
 *
 */
interface JsApiTicketApi extends WxMpApi {

    final String API_URL_getTicket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket"
    final String API_URL_getWxCardTicket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket"

    // ----------------------------------------------

    /**
     *
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
     * 调用微信卡券JS API的临时票据，有效期为7200 秒，通过access_token 来获取
     */
    GetWxCardTicketResp getWxCardTicket(
            String access_token
    )

    static class GetWxCardTicketResp extends BaseResp {
        String ticket
        Integer expires_in
    }
}
