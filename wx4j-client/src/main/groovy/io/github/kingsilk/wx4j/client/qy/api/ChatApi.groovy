package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi

/**
 * 企业会话接口
 */
interface ChatApi extends WxQyApi {

    final String API_URL_create = "https://qyapi.weixin.qq.com/cgi-bin/chat/create"
    final String API_URL_info = "https://qyapi.weixin.qq.com/cgi-bin/chat/get"
    final String API_URL_update = "https://qyapi.weixin.qq.com/cgi-bin/chat/update"
    final String API_URL_quit = "https://qyapi.weixin.qq.com/cgi-bin/chat/quit"
    final String API_URL_clearNotify = "https://qyapi.weixin.qq.com/cgi-bin/chat/clearnotify"


    // ----------------------------------------------


}
