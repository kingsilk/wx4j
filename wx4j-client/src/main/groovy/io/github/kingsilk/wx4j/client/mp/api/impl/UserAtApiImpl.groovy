package io.github.kingsilk.wx4j.client.mp.api.impl

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.api.UserAtApi
import io.github.kingsilk.wx4j.client.mp.api.UserAtApi.GetUserAtResp
import io.github.kingsilk.wx4j.client.mp.api.UserAtApi.IsValidResp
import io.github.kingsilk.wx4j.client.mp.api.UserAtApi.RefreshResp
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
@CompileStatic
class UserAtApiImpl extends AbstractWxMpApi implements UserAtApi {

    RestOperations restTemplate

    final Map<String, String> defaultApiUrls = Collections.unmodifiableMap([
            createUserAuthUrl: API_URL_createUserAuthUrl,
            isValid          : API_URL_isValid,
            refresh          : API_URL_refresh,
            getUserAt        : API_URL_getUserAt
    ])

    UserAtApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    @Override
    String createUserAuthUrl(
            String appid,
            String redirect_uri,
            String scope,
            String state
    ) {

        String apiUrl = getApiUrl("isValid")
        URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam('appid', appid)
                .queryParam('redirect_uri', redirect_uri)
                .queryParam('response_type', "code")
                .queryParam('scope', scope)
                .queryParam('state', state)
                .build()
                .encode("UTF-8")
                .toUri()

        return uri.toString()
    }

    @Override
    IsValidResp isValid(String access_token, String openid) {

        String apiUrl = getApiUrl("isValid")
        URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam('access_token', access_token)
                .queryParam('openid', openid)
                .build()
                .encode("UTF-8")
                .toUri()


        ResponseEntity<IsValidResp> respEntity = restTemplate.getForEntity(uri, IsValidResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        IsValidResp resp = respEntity.body

        resp.check()

        return resp
    }


    @Override
    RefreshResp refresh(
            String appid,
            String refresh_token
    ) {

        String apiUrl = getApiUrl("refresh")
        URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam('appid', appid)
                .queryParam('grant_type', "refresh_token")
                .queryParam('refresh_token', refresh_token)
                .build()
                .encode("UTF-8")
                .toUri()

        ResponseEntity<RefreshResp> respEntity = restTemplate.getForEntity(uri, RefreshResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        RefreshResp resp = respEntity.body

        resp.check()

        return resp
    }

    /**
     * 通过 code 换取用户级别的 access token。
     */
    @Override
    GetUserAtResp getUserAt(
            String appid,
            String secret,
            String code
    ) {

        String apiUrl = getApiUrl("getUserAt")
        URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam('appid', appid)
                .queryParam('secret', secret)
                .queryParam('code', code)
                .queryParam('grant_type', "authorization_code")
                .build()
                .encode("UTF-8")
                .toUri()

        ResponseEntity<GetUserAtResp> respEntity = restTemplate.getForEntity(uri, GetUserAtResp)

        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        GetUserAtResp resp = respEntity.body

        resp.check()

        return resp
    }
}
