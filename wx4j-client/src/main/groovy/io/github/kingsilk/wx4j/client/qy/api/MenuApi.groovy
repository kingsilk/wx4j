package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi

/**
 * 自定义菜单
 */
interface MenuApi extends WxQyApi {

    final String API_URL_create = "https://qyapi.weixin.qq.com/cgi-bin/menu/create"
    final String API_URL_del = "https://qyapi.weixin.qq.com/cgi-bin/menu/delete"
    final String API_URL_info = "https://qyapi.weixin.qq.com/cgi-bin/menu/get"

    // ----------------------------------------------


}
