package io.github.kingsilk.wx4j.client.pay.api

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.WxMpApi
import io.github.kingsilk.wx4j.client.pay.WxPayApi.BaseReq
import io.github.kingsilk.wx4j.client.pay.WxPayApi.BaseResp

/**
 * 对账单相关API
 */
@CompileStatic
interface BillApi extends WxMpApi {

    String API_URL_download = "https://api.mch.weixin.qq.com/pay/downloadbill"

    // ----------------------------------------------

    /**
     * 下载对账单
     */
    DownloadResp download(
            DownloadReq downloadReq
    )

    static class DownloadReq extends BaseReq {

        /** 公众账号ID */
        String appid

        /** 商户号 */
        String mch_id

        /** 设备号 */
        String device_info

        /** 随机字符串 */
        String nonce_str

        /** 签名 */
        String sign

        /** 签名类型 */
        String sign_type

        /** 对账单日期 */
        String bill_date

        /** 账单类型 */
        String bill_type

        /** 压缩账单 */
        String tar_type
    }

    static class DownloadResp extends BaseResp {
        byte[] bytes
    }


}
