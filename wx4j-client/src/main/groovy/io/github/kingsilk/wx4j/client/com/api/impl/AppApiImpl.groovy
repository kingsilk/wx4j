package io.github.kingsilk.wx4j.client.com.api.impl

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.com.api.AppApi
import io.github.kingsilk.wx4j.client.com.api.AppApi.GetOptionReq
import io.github.kingsilk.wx4j.client.com.api.AppApi.GetOptionResp
import io.github.kingsilk.wx4j.client.com.api.AppApi.InfoReq
import io.github.kingsilk.wx4j.client.com.api.AppApi.InfoResp
import io.github.kingsilk.wx4j.client.com.api.AppApi.SetOptionReq
import io.github.kingsilk.wx4j.client.com.api.AppApi.SetOptionResp
import org.springframework.http.*
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
@CompileStatic
class AppApiImpl extends AbstractWxComApi implements AppApi {

    RestOperations restTemplate

    final Map<String, String> defaultApiUrls = Collections.unmodifiableMap([
            info     : API_URL_info,
            getOption: API_URL_getOption,
            setOption: API_URL_setOption
    ])

    AppApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    /** 获取授权方的帐号基本信息 */
    @Override
    InfoResp info(
            String component_access_token,
            InfoReq infoReq
    ) {

        URI uri = UriComponentsBuilder
                .fromHttpUrl(API_URL_info)
                .queryParam("component_access_token", component_access_token)
                .build()
                .encode("UTF-8")
                .toUri()

        HttpHeaders headers = new HttpHeaders()
        headers.setAccept([MediaType.APPLICATION_JSON])
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
        HttpEntity<InfoReq> reqEntity = new HttpEntity(infoReq, headers)

        ResponseEntity<InfoResp> respEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                reqEntity,
                InfoResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")


        InfoResp resp = respEntity.getBody()

        resp.check()

        return resp
    }

    /** 获取授权方的选项设置信息 */
    @Override
    GetOptionResp getOption(
            String component_access_token,
            GetOptionReq getOptionReq
    ) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(API_URL_getOption)
                .queryParam("component_access_token", component_access_token)
                .build()
                .encode("UTF-8")
                .toUri()

        HttpHeaders headers = new HttpHeaders()
        headers.setAccept([MediaType.APPLICATION_JSON])
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
        HttpEntity<GetOptionReq> reqEntity = new HttpEntity(getOptionReq, headers)

        ResponseEntity<GetOptionResp> respEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                reqEntity,
                GetOptionResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")


        GetOptionResp resp = respEntity.getBody()

        resp.check()

        return resp
    }

    /** 获取授权方的选项设置信息 */
    @Override
    SetOptionResp setOption(
            String component_access_token,
            SetOptionReq setOptionReq
    ) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(API_URL_setOption)
                .queryParam("component_access_token", component_access_token)
                .build()
                .encode("UTF-8")
                .toUri()

        HttpHeaders headers = new HttpHeaders()
        headers.setAccept([MediaType.APPLICATION_JSON])
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8)
        HttpEntity<SetOptionReq> reqEntity = new HttpEntity(setOptionReq, headers)

        ResponseEntity<SetOptionResp> respEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                reqEntity,
                SetOptionResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        SetOptionResp resp = respEntity.getBody()

        resp.check()

        return resp
    }
}
