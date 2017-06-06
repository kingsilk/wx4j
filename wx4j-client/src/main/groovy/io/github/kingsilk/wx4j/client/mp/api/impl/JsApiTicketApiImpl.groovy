package io.github.kingsilk.wx4j.client.mp.api.impl

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.api.JsApiTicketApi
import io.github.kingsilk.wx4j.client.mp.api.JsApiTicketApi.GetTicketResp
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
@CompileStatic
class JsApiTicketApiImpl extends AbstractWxMpApi implements JsApiTicketApi {


    RestOperations restTemplate

    final Map<String, String> defaultApiUrls = Collections.unmodifiableMap([
            getTicket: API_URL_getTicket
    ])

    JsApiTicketApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    @Override
    GetTicketResp getTicket(String access_token) {

        String apiUrl = getApiUrl("getTicket")
        URI uri = UriComponentsBuilder.fromHttpUrl(getApiUrl(apiUrl))
                .queryParam('access_token', access_token)
                .queryParam('type', "jsapi")
                .build()
                .encode("UTF-8")
                .toUri()

        ResponseEntity<GetTicketResp> respEntity = restTemplate.getForEntity(uri, GetTicketResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")


        GetTicketResp resp = respEntity.body

        resp.check()

        return resp
    }
}
