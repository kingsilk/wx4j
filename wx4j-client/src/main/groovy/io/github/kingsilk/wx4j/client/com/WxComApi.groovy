package io.github.kingsilk.wx4j.client.com

import groovy.json.JsonOutput
import io.github.kingsilk.wx4j.client.core.WxApi
import org.springframework.util.Assert;

/**
 * 微信 - 开放平台 - 第三方平台相关的API。
 */
interface WxComApi extends WxApi {

    /**
     *
     */
    abstract class BaseReq implements Serializable {

        public static final long serialVersionUID = 1L


        @Override
        String toString() {
            return JsonOutput.toJson(this)
        }
    }
    /**
     *
     */
    abstract class BaseResp implements Serializable {

        public static final long serialVersionUID = 1L

        Integer errcode
        String errmsg

        /**
         * 注意：仅仅是以 JSON 的形式反映当前绑定的数据。可能不匹配微信服务器实际返回的内容。
         * 微信服务器实际返回的内容，建议使用  apache http client ，
         * 开启 logger "org.apache.http.wire" DEBUG 级别的日志。
         *
         * @return
         */
        @Override
        String toString() {
            return JsonOutput.toJson(this)
        }


        void check() {
            Assert.isTrue(this.errcode == null || this.errcode == 0,
                    this.errmsg ?: "调用微信API异常，错误码 - " + this.errcode)
        }
    }
}
