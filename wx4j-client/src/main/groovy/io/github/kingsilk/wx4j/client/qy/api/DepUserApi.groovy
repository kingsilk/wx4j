package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi

/**
 * 部门成员管理
 */
interface DepUserApi extends WxQyApi {

    final String API_URL_create = "https://qyapi.weixin.qq.com/cgi-bin/user/create"
    final String API_URL_update = "https://qyapi.weixin.qq.com/cgi-bin/user/update"
    final String API_URL_del = "https://qyapi.weixin.qq.com/cgi-bin/user/delete"
    final String API_URL_batchDel = "https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete"
    final String API_URL_info = "https://qyapi.weixin.qq.com/cgi-bin/user/get"
    final String API_URL_listUserByDep = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist"
    final String API_URL_list = "https://qyapi.weixin.qq.com/cgi-bin/user/list"

    // ----------------------------------------------


}
