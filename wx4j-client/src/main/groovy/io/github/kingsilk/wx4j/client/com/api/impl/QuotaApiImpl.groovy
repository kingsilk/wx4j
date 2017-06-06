package io.github.kingsilk.wx4j.client.com.api.impl

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.com.api.QuotaApi
import io.github.kingsilk.wx4j.client.com.api.QuotaApi.ClearResp
import org.springframework.http.*
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
@CompileStatic
class QuotaApiImpl extends AbstractWxComApi implements QuotaApi {

    RestOperations restTemplate

    final Map<String, String> defaultApiUrls = Collections.unmodifiableMap([
            clear: API_URL_clear
    ])

    QuotaApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    @Override
    ClearResp clear(String component_access_token, ClearResp clearReq) {

        URI uri = UriComponentsBuilder
                .fromHttpUrl(API_URL_clear)
                .queryParam("component_access_token", component_access_token)
                .build()
                .encode("UTF-8")
                .toUri()

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept([MediaType.APPLICATION_JSON])
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
        HttpEntity<ClearResp> reqEntity = new HttpEntity(clearReq, headers)

        ResponseEntity<ClearResp> respEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                reqEntity,
                ClearResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        ClearResp resp = respEntity.getBody()

        resp.check()

        return resp
    }
}
