package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi

/**
 * 部门管理
 */
interface DepApi extends WxQyApi {

    final String API_URL_create = "https://qyapi.weixin.qq.com/cgi-bin/department/create"
    final String API_URL_del = "https://qyapi.weixin.qq.com/cgi-bin/department/delete"
    final String API_URL_list = "https://qyapi.weixin.qq.com/cgi-bin/department/list"

    // ----------------------------------------------


}
