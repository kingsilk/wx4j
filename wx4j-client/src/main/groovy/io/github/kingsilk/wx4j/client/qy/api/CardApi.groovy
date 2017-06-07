package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi

/**
 * 卡券服务
 */
interface CardApi extends WxQyApi {

    final String API_URL_create = "https://qyapi.weixin.qq.com/cgi-bin/card/create"
    final String API_URL_info = "https://qyapi.weixin.qq.com/cgi-bin/card/get"
    final String API_URL_send = "https://qyapi.weixin.qq.com/cgi-bin/message/send"
    final String API_URL_getMpNewsHtml = "https://qyapi.weixin.qq.com/cgi-bin/card/mpnews/gethtml"
    final String API_URL_createQrcode = "https://qyapi.weixin.qq.com/cgi-bin/card/qrcode/create"
    final String API_URL_getByCode = "https://qyapi.weixin.qq.com/cgi-bin/card/code/get"
    final String API_URL_consume = "https://qyapi.weixin.qq.com/cgi-bin/card/code/consume"

    // ----------------------------------------------


}
