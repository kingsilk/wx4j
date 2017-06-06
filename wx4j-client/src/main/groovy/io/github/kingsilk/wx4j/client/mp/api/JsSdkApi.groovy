package io.github.kingsilk.wx4j.client.mp.api

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.WxMpApi

/**
 * 模板消息接口
 */
@CompileStatic
interface JsSdkApi extends WxMpApi {

    final String API_URL_getMedia = "https://api.weixin.qq.com/cgi-bin/media/get/jssdk"

    // ----------------------------------------------
    /**
     * 公众号可以使用本接口获取从JSSDK的uploadVoice接口上传的临时语音素材。
     * 格式为speex，16K采样率
     */
    byte[] getMedia(
            String access_token,
            String media_id
    )


}
