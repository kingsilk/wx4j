package io.github.kingsilk.wx4j.client.mp.api.impl

import io.github.kingsilk.wx4j.client.mp.api.AppAtApi
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
class AppAtApiImpl implements AppAtApi {

    RestOperations restTemplate

    AppAtApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    @Override
    GetAppAtResp getAppAt(String appid, String secret) {

        // client_credential
        URI uri = UriComponentsBuilder.fromHttpUrl(API_URI_getAppAt)
                .queryParam('grant_type', "client_credential")
                .queryParam('appid', appid)
                .queryParam('secret', secret)
                .build()
                .encode("UTF-8")
                .toUri()

        ResponseEntity<GetAppAtResp> respEntity = restTemplate.getForEntity(uri, GetAppAtResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        GetAppAtResp resp = respEntity.body

        resp.check()

        return resp
    }
}
