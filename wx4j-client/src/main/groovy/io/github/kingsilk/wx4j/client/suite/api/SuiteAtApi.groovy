package io.github.kingsilk.wx4j.client.suite.api

import io.github.kingsilk.wx4j.client.suite.WxSuiteApi

/**
 * 第三方应用接口
 */
interface SuiteAtApi extends WxSuiteApi {

    final String API_URL_getAt = "https://qyapi.weixin.qq.com/cgi-bin/service/get_suite_token"
    final String API_URL_conf = "https://qyapi.weixin.qq.com/cgi-bin/service/set_session_info"

    // ----------------------------------------------

}
