package io.github.kingsilk.wx4j.client.pay.api.impl

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.pay.api.BillApi
import io.github.kingsilk.wx4j.client.pay.api.BillApi.DownloadReq
import io.github.kingsilk.wx4j.client.pay.api.BillApi.DownloadResp
import org.springframework.web.client.RestOperations

/**
 *
 */
@CompileStatic
class BillApiImpl extends AbstractWxPayApi implements BillApi {

    RestOperations restTemplate

    final Map<String, String> defaultApiUrls = Collections.unmodifiableMap([
            download: API_URL_download
    ])

    BillApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }


    @Override
    DownloadResp download(
            DownloadReq downloadReq
    ) {
        return null
    }
}
