package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi
import io.github.kingsilk.wx4j.client.qy.WxQyApi.BaseReq
import io.github.kingsilk.wx4j.client.qy.WxQyApi.BaseResp

/**
 * 管理企业号应用。
 */
interface QyAppApi extends WxQyApi {

    final String API_URL_info = "https://qyapi.weixin.qq.com/cgi-bin/agent/get"
    final String API_URL_conf = "https://qyapi.weixin.qq.com/cgi-bin/agent/set"
    final String API_URL_list = "https://qyapi.weixin.qq.com/cgi-bin/agent/list"

    // ----------------------------------------------
    /**
     * 获取企业号应用信息
     * @param agentid 企业应用的id
     */
    InfoResp info(
            String access_token,
            String agentid
    )

    static class InfoResp extends BaseResp {

        /** 企业应用id */
        String agentid

        /** 企业应用名称 */
        String name

        /** 企业应用方形头像 */
        String square_logo_url

        /** 企业应用圆形头像 */
        String round_logo_url

        /** 企业应用详情 */
        String description

        /** 企业应用可见范围（人员），其中包括userid和关注状态state */
        AllowUserUnfos allow_userinfos

        /** 企业应用可见范围（部门）*/
        AllowPartys allow_partys

        /** 企业应用可见范围（标签） */
        AllowTags allow_tags

        /** 企业应用是否被禁用 */
        Integer close

        /** 企业应用可信域名 */
        String redirect_domain

        /**
         * 企业应用是否打开地理位置上报
         *
         * 0 - 不上报
         * 1 - 进入会话上报
         * 2 - 持续上报
         */
        Integer report_location_flag

        /**
         * 是否接收用户变更通知。
         *
         * 0 - 不接收
         * 1 - 接收
         */
        Integer isreportuser

        /**
         * 是否上报用户进入应用事件。
         *
         * 0 - 不接收
         * 1 - 接收
         */
        Integer isreportenter

        /**
         * 关联会话url
         */
        String chat_extension_url

        /**
         * 应用类型。
         * 1 - 消息型
         * 2 - 主页型
         */
        Integer type

        public static class AllowUserUnfos {
            List<User> user

            public static class User {
                String userid
                String status
            }
        }

        public static class AllowPartys {
            List<Integer> partyid
        }

        public static class AllowTags {
            List<Integer> tagid
        }
    }

    // ----------------------------------------------
    /**
     * 设置企业号应用
     */
    ConfResp conf(
            String access_token,
            ConfReq confReq
    )

    static class ConfReq extends BaseReq {
        String agentid
        String report_location_flag
        String logo_mediaid
        String name
        String description
        String redirect_domain
        Integer isreportuser
        Integer isreportenter
        String home_url
        String chat_extension_url
    }

    static class ConfResp extends BaseResp {

    }

    // ----------------------------------------------
    /**
     * 获取应用概况列表
     */
    ListResp list(
            String access_token
    )

    static class ListResp extends BaseResp {
        List<Agent> agentlist

        public static class Agent {

            /** 应用id */
            String agentid

            /** 应用名称 */
            String name

            /** 方形头像url */
            String square_logo_url

            /** 圆形头像url */
            String round_logo_url
        }
    }

}
