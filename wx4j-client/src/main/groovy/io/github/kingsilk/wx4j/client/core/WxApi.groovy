package io.github.kingsilk.wx4j.client.core

/**
 *
 */
interface WxApi {

    void setApiUrls(Map<String, String> apiUrls)

    Map<String, String> getDefaultApiUrls()

    String getApiUrl(String apiName)
}
