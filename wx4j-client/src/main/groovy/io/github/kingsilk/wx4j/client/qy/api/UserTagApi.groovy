package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi

/**
 * 成员标签管理
 */
interface UserTagApi extends WxQyApi {

    final String API_URL_create = "https://qyapi.weixin.qq.com/cgi-bin/tag/create"
    final String API_URL_update = "https://qyapi.weixin.qq.com/cgi-bin/tag/update"
    final String API_URL_del = "https://qyapi.weixin.qq.com/cgi-bin/tag/delete"
    final String API_URL_listUserByTag = "https://qyapi.weixin.qq.com/cgi-bin/tag/get"
    final String API_URL_tagUser = "https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers"
    final String API_URL_untagUser = "https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers"
    final String API_URL_list = "https://qyapi.weixin.qq.com/cgi-bin/tag/list"

    // ----------------------------------------------

}
