package io.github.kingsilk.wx4j.client.com.api.impl

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.com.api.AppAtApi
import io.github.kingsilk.wx4j.client.com.api.AppAtApi.GetAppAtReq
import io.github.kingsilk.wx4j.client.com.api.AppAtApi.GetAppAtResp
import io.github.kingsilk.wx4j.client.com.api.AppAtApi.PreAuthReq
import io.github.kingsilk.wx4j.client.com.api.AppAtApi.PreAuthResp
import org.springframework.http.*
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
@CompileStatic
class AppAtApiImpl extends AbstractWxComApi implements AppAtApi {

    RestOperations restTemplate

    final Map<String, String> defaultApiUrls = Collections.unmodifiableMap([
            preAuth         : API_URL_preAuth,
            createAppAuthUrl: API_URL_createAppAuthUrl,
            getAppAt        : API_URL_getAppAt
    ])

    AppAtApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    /** 获取预授权码 */
    @Override
    PreAuthResp preAuth(
            String component_access_token,
            PreAuthReq preAuthReq
    ) {

        URI uri = UriComponentsBuilder
                .fromHttpUrl(API_URL_preAuth)
                .queryParam("component_access_token", component_access_token)
                .build()
                .encode("UTF-8")
                .toUri()

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept([MediaType.APPLICATION_JSON])
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
        HttpEntity<PreAuthResp> reqEntity = new HttpEntity(preAuthReq, headers)

        ResponseEntity<PreAuthResp> respEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                reqEntity,
                PreAuthResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")


        PreAuthResp resp = respEntity.getBody()

        resp.check()

        return resp
    }

    @Override
    String createAppAuthUrl(
            String component_appid,
            String pre_auth_code,
            String redirect_uri
    ) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(API_URL_createAppAuthUrl)
                .queryParam("component_appid", component_appid)
                .queryParam("pre_auth_code", pre_auth_code)
                .queryParam("redirect_uri", redirect_uri)
                .build()
                .encode("UTF-8")
                .toUri()
        return uri.toString()
    }

    @Override
    GetAppAtResp getAppAt(
            String component_access_token,
            GetAppAtReq getAppAtReq
    ) {

        URI uri = UriComponentsBuilder
                .fromHttpUrl(API_URL_getAppAt)
                .queryParam("component_access_token", component_access_token)
                .build()
                .encode("UTF-8")
                .toUri()

        HttpHeaders headers = new HttpHeaders()
        headers.setAccept([MediaType.APPLICATION_JSON])
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
        HttpEntity<GetAppAtReq> reqEntity = new HttpEntity(getAppAtReq, headers)

        ResponseEntity<GetAppAtResp> respEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                reqEntity,
                GetAppAtResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")


        GetAppAtResp resp = respEntity.getBody()

        resp.check()

        return resp

    }
}