package io.github.kingsilk.wx4j.client.mp.api

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.WxMpApi
import io.github.kingsilk.wx4j.client.mp.WxMpApi.BaseReq
import io.github.kingsilk.wx4j.client.mp.WxMpApi.BaseResp

/**
 * 黑名单管理
 */
@CompileStatic
interface BlackListApi extends WxMpApi {

    final String API_URL_list = "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist"
    final String API_URL_black = "https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist"
    final String API_URL_unblack = "https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist"

    // ----------------------------------------------
    /**
     * 获取公众号的黑名单列表
     */
    ListResp list(
            String access_token,
            ListReq listReq
    )

    static class ListReq extends BaseReq {
        String begin_openid
    }

    static class ListResp extends BaseResp {

        Integer total
        Integer count
        Data data
        public static class Data {
            List<String> openid
            String next_openid
        }
    }

    // ----------------------------------------------
    /**
     * 拉黑用户
     */
    BlackResp black(
            String access_token,
            BlackReq blackReq
    )

    static class BlackReq extends BaseReq {
        List<String> openid_list  // FIXME 文档与示例不一致
    }

    static class BlackResp extends BaseResp {

    }

    // ----------------------------------------------
    /**
     * 拉黑用户
     */
    UnlackResp unblack(
            String access_token,
            UnlackReq unlackReq
    )

    static class UnlackReq extends BaseReq {
        List<String> openid_list
    }

    static class UnlackResp extends BaseResp {

    }

}
