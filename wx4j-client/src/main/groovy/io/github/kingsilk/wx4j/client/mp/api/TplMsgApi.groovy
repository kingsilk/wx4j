package io.github.kingsilk.wx4j.client.mp.api

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.WxMpApi
import io.github.kingsilk.wx4j.client.mp.WxMpApi.BaseReq
import io.github.kingsilk.wx4j.client.mp.WxMpApi.BaseResp

/**
 * 模板消息接口
 */
@CompileStatic
interface TplMsgApi extends WxMpApi {

    final String API_URL_setIndustry = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry"
    final String API_URL_getIndustry = "https://api.weixin.qq.com/cgi-bin/template/get_industry"
    final String API_URL_add = "https://api.weixin.qq.com/cgi-bin/template/api_add_template"
    final String API_URL_list = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template"
    final String API_URL_del = "https://api.weixin.qq.com/cgi-bin/template/del_private_template"
    final String API_URL_send = "https://api.weixin.qq.com/cgi-bin/message/template/send"

    // ----------------------------------------------
    /**
     * 设置所属行业
     */
    SetIndustrygResp setIndustry(
            String access_token,
            SetIndustrygReq setIndustrygReq
    )

    static class SetIndustrygReq extends BaseReq {

        /**
         * 公众号模板消息所属行业编号
         */
        String industry_id1

        /**
         * 公众号模板消息所属行业编号
         */
        String industry_id2

    }

    static class SetIndustrygResp extends BaseResp {
    }

    // ----------------------------------------------
    /**
     * 获取设置的行业信息
     */
    GetIndustrygResp getIndustry(
            String access_token
    )

    static class GetIndustrygResp extends BaseResp {

        /**
         * 帐号设置的主营行业
         */
        Industry primary_industry

        /**
         * 帐号设置的副营行业
         */
        Industry secondary_industry


        public static class Industry {
            String first_class
            String second_class
        }
    }

    // ----------------------------------------------
    AddResp add(
            String access_token,
            AddReq addReq
    )

    static class AddReq extends BaseReq {

        /**
         * 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
         */
        String template_id_short
    }

    static class AddResp extends BaseResp {
        String template_id
    }

    // ----------------------------------------------
    ListResp list(
            String access_token
    )

    static class ListResp extends BaseResp {

        List<Template> template_list

        public static class Template {
            String template_id
            String title
            String primary_industry
            String deputy_industry
            String content
            String example

        }
    }

    // ----------------------------------------------
    /**
     * 删除模板
     */
    DelResp del(
            String access_token,
            DelReq delReq
    )

    static class DelReq extends BaseReq {

        /**
         * 公众帐号下模板消息ID
         */
        String template_id

    }

    static class DelResp extends BaseResp {

    }

    // ----------------------------------------------
    SendResp send(
            String access_token,
            SendReq sendReq
    )

    static class SendReq extends BaseReq {

        String touser
        String template_id
        String url
        MiniProgram miniprogram
        Map<String, Val> data


        public static class MiniProgram {
            String appid
            String pagepath
        }

        public static class Val {
            String value
            String color
        }
    }

    static class SendResp extends BaseResp {
        String msgid
    }


}
