package com.github.btpka3.weixin4j.mp.api.kf

import com.github.btpka3.weixin4j.mp.api.WxMpApi
import groovy.transform.CompileStatic

/**
 * 修改客服帐号
 */
@CompileStatic
interface UpdateKfApi extends WxMpApi<Query, Req, Void> {

    String API_URI = "https://api.weixin.qq.com/customservice/kfaccount/update"

    static class Query {
        String access_token
    }

    static class Req {
        String kf_account
        String nickname
        String password
    }
}
