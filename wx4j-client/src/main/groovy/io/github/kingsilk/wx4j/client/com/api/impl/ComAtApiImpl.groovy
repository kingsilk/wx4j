package io.github.kingsilk.wx4j.client.com.api.impl

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.com.api.ComAtApi
import io.github.kingsilk.wx4j.client.com.api.ComAtApi.GetComAtReq
import io.github.kingsilk.wx4j.client.com.api.ComAtApi.GetComAtResp
import org.springframework.http.*
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
@CompileStatic
class ComAtApiImpl extends AbstractWxComApi implements ComAtApi {

    RestOperations restTemplate

    final Map<String, String> defaultApiUrls = Collections.unmodifiableMap([
            getComAt: API_URL_getComAt
    ])

    ComAtApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    @Override
    GetComAtResp getComAt(
            GetComAtReq getComAtReq
    ) {

        URI uri = UriComponentsBuilder
                .fromHttpUrl(API_URL_getComAt)
                .build()
                .toUri()

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
        HttpEntity<GetComAtResp> reqEntity = new HttpEntity(getComAtReq, headers)

        ResponseEntity<GetComAtResp> respEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                reqEntity,
                GetComAtResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        GetComAtResp resp = respEntity.getBody()

        resp.check()

        return resp
    }
}
