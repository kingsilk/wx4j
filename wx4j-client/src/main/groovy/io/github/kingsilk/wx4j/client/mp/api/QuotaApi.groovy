package io.github.kingsilk.wx4j.client.mp.api

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.WxMpApi
import io.github.kingsilk.wx4j.client.mp.WxMpApi.BaseResp

/**
 * 限制清除相关 Api
 */
@CompileStatic
interface QuotaApi extends WxMpApi {

    final String API_URL_clear = "https://api.weixin.qq.com/cgi-bin/clear_quota"


    // ----------------------------------------------
    ClearResp clear(
            String access_token,
            String secret
    )

    static class ClearResp extends BaseResp {

    }

}
