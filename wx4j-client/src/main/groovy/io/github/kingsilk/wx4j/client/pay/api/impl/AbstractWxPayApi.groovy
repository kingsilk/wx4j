package io.github.kingsilk.wx4j.client.pay.api.impl

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.pay.WxPayApi
import org.springframework.util.Assert

/**
 *
 */
@CompileStatic
abstract class AbstractWxPayApi implements WxPayApi {

    Map<String, String> apiUrls

    String getApiUrl(String apiName) {
        Assert.isTrue(apiName as boolean, "apiName 不能为空")

        if (apiUrls && apiUrls.get(apiName)) {
            return apiUrls.get(apiName)
        }

        Map<String, String> defaultApiUrls = getDefaultApiUrls()

        String apiUrl

        if (defaultApiUrls && defaultApiUrls.get(apiName)) {
            apiUrl = defaultApiUrls.get(apiName)
        }

        Assert.isTrue(apiUrl as boolean, "`API ${apiName}` 的 url 未正确配置")
        return apiUrl
    }
}
