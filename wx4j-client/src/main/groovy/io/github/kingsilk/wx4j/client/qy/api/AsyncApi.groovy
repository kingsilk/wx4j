package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi
import io.github.kingsilk.wx4j.client.qy.WxQyApi.BaseReq
import io.github.kingsilk.wx4j.client.qy.WxQyApi.BaseResp

/**
 * 异步任务接口
 */
interface AsyncApi extends WxQyApi {

    final String API_URL_syncUser = "https://qyapi.weixin.qq.com/cgi-bin/batch/syncuser"
    final String API_URL_replaceUser = "https://qyapi.weixin.qq.com/cgi-bin/batch/replaceuser"
    final String API_URL_replaceDep = "https://qyapi.weixin.qq.com/cgi-bin/batch/replaceparty"
    final String API_URL_getResult = "https://qyapi.weixin.qq.com/cgi-bin/batch/getresult"


    // ----------------------------------------------

}
