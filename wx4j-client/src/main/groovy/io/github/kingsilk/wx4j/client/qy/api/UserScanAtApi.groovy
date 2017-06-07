package io.github.kingsilk.wx4j.client.qy.api

import io.github.kingsilk.wx4j.client.qy.WxQyApi
import io.github.kingsilk.wx4j.client.qy.WxQyApi.BaseReq
import io.github.kingsilk.wx4j.client.qy.WxQyApi.BaseResp

/**
 * 在微信APP以外，通过扫码登录认证授权相关API。
 */
interface UserScanAtApi extends WxQyApi {

    final String API_URL_createLoginUrl = "https://qy.weixin.qq.com/cgi-bin/loginpage"
    final String API_URL_getLoginInfo = "https://qyapi.weixin.qq.com/cgi-bin/service/get_login_info"
    final String API_URL_getWxQyLoginUrl = "https://qyapi.weixin.qq.com/cgi-bin/service/get_login_url"

    // ----------------------------------------------

    /**
     * 使用user_ticket获取成员详情
     * @param usertype redirect_uri支持登录的类型
     *  member - 成员登录
     *  admin  - 管理员登录 (默认)
     *  all    - 成员或管理员皆可登录
     */
    String createLoginUrl(
            String corp_id,
            String redirect_uri,
            String state,
            String usertype
    )

    // ----------------------------------------------
    /**
     * 获取企业号登录用户信息
     */
    GetLoginInfoResp getLoginInfo(
            String access_token,
            GetLoginInfoReq getLoginInfoReq
    )

    static class GetLoginInfoReq extends BaseReq {

        /**
         * oauth2.0授权企业号管理员登录产生的code。
         * 只能使用一次，10分钟未被使用自动过期
         */
        String auth_code
    }

    static class GetLoginInfoResp extends BaseResp {

        /**
         * 登录用户的类型
         *
         * 1 - 企业号创建者
         * 2 - 企业号内部系统管理员
         * 3 - 企业号外部系统管理员
         * 4 - 企业号分级管理员
         * 5 - 企业号成员
         */
        Integer usertype


        UserInfo user_info
        CorpInfo corp_info
        List<Agent> agent
        AuthInfo auth_info
        RedirectLoginInfo redirect_login_info

        /**
         * 登录管理员的信息
         */
        public static class UserInfo {

            // 登录用户为企业号创建者或外部系统管理员时，以下一个字段有值。
            String email

            // 登录用户为企业号内部系统管理员或分级管理员时，以下三个字段有值。
            // 登录用户为企业号成员时，以下三个字段有值。
            String userid
            String name
            String avatar
        }

        /**
         * 授权方企业信息
         */
        public static class CorpInfo {

            /** 授权方企业号id */
            String corpid
        }

        /**
         * 该管理员在该提供商中能使用的应用列表
         */
        public static class Agent {

            /**
             * 应用id
             */
            Integer agentid

            /**
             * 该管理员对应用的权限：
             *
             * 1 - 管理权限
             * 0 - 使用权限
             */
            Integer auth_type
        }

        /**
         * 该管理员拥有的通讯录权限
         */
        public static class AuthInfo {
            List<Dpartment> department

            public static class Dpartment {
                String id
                String writable
            }
        }

        /**
         * 登录跳转的票据信息
         */
        public static class RedirectLoginInfo {

            /** 登录跳转的票据 */
            String login_ticket

            /** 登录跳转票据的有效时长，单位为秒 */
            Integer expires_in
        }
    }

    // ----------------------------------------------

    /**
     * 在已经登录第三方网站后，获取自动登录到微信企业号管理后台 https://qy.weixin.qq.com/ 的网址。
     */
    GetWxQyLoginUrlResp getWxQyLoginUrl(
            String access_token,
            GetWxQyLoginUrlReq getWxQyLoginUrlReq
    )

    static class GetWxQyLoginUrlReq extends BaseReq {

        /**
         *
         */
        String login_ticket

        /**
         * 登录跳转到企业号后台的目标页面。目前有：
         * agent_setting -
         * send_msg      -
         * contact       -
         */
        String target

        /**
         * 授权方应用id
         */
        Integer agentid
    }

    static class GetWxQyLoginUrlResp extends BaseResp {

        /**
         * 登录跳转的url，一次性有效，不可多次使用
         */
        String login_url

        /**
         * url有效时长，单位为秒
         */
        Integer expires_in
    }

}
