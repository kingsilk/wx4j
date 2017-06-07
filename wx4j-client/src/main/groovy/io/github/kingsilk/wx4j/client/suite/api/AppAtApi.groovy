package io.github.kingsilk.wx4j.client.suite.api

import io.github.kingsilk.wx4j.client.suite.WxSuiteApi

/**
 * 代为管理的微信企业号相关的认证授权API。
 */
interface AppAtApi extends WxSuiteApi {

    final String API_URL_createAuthUrl = "http://qy.weixin.qq.com/cgi-bin/3rd_loginpage"
    final String API_URL_createScanAuthUrl = "https://qy.weixin.qq.com/cgi-bin/loginpage"

    final String API_URL_preAuth = "https://qyapi.weixin.qq.com/cgi-bin/service/get_pre_auth_code"
    final String API_URL_getAppAt = "https://qyapi.weixin.qq.com/cgi-bin/service/get_permanent_code"
    final String API_URL_info = "https://qyapi.weixin.qq.com/cgi-bin/service/get_auth_info"

    // ----------------------------------------------

}
