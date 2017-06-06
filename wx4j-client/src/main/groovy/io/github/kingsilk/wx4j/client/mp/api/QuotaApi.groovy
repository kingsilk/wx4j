package io.github.kingsilk.wx4j.client.mp.api

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.WxMpApi

import static WxMpApi.BaseResp

/**
 * 限制清除相关 Api
 */
@CompileStatic
interface QuotaApi extends WxMpApi {

    String API_URI_clear = "https://api.weixin.qq.com/cgi-bin/clear_quota"


    ClearResp clear(
            String access_token,
            String secret
    )

    static class ClearResp extends BaseResp {

    }

}
