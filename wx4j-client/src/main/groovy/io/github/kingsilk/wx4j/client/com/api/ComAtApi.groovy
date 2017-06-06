package io.github.kingsilk.wx4j.client.com.api

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.com.WxComApi
import io.github.kingsilk.wx4j.client.com.WxComApi.BaseReq
import io.github.kingsilk.wx4j.client.com.WxComApi.BaseResp

/**
 *
 */
@CompileStatic
interface ComAtApi extends WxComApi {


    String API_URL_getComAt = "https://api.weixin.qq.com/cgi-bin/component/api_component_token"

    /**
     *
     * @param getComAtReq
     * @return
     */
    GetComAtResp getComAt(
            GetComAtReq getComAtReq
    )

    static class GetComAtReq extends BaseReq {
        /** 第三方平台方appid */
        String component_appsecret

        /** 第三方平台appsecret */
        String component_verify_ticket

        /** 微信后台推送的ticket，此ticket会定时推送 */
        String component_appid
    }

    static class GetComAtResp extends BaseResp {

        /** 第三方平台access_token */
        String component_access_token

        /** 有效期 */
        Integer expires_in
    }


}
