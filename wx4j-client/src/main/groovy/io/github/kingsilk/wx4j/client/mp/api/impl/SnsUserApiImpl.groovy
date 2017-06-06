package io.github.kingsilk.wx4j.client.mp.api.impl

import io.github.kingsilk.wx4j.client.mp.api.SnsUserApi
import io.github.kingsilk.wx4j.client.mp.api.SnsUserApi.InfoResp
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.client.RestOperations
import org.springframework.web.util.UriComponentsBuilder

/**
 *
 */
class SnsUserApiImpl extends AbstractWxMpApi implements SnsUserApi {


    RestOperations restTemplate

    final Map<String, String> defaultApiUrls = Collections.unmodifiableMap([
            info: API_URL_info
    ])

    SnsUserApiImpl(RestOperations restTemplate) {
        this.restTemplate = restTemplate
    }

    @Override
    InfoResp info(String access_token, String openid, String lang) {

        String apiUrl = getApiUrl("info")
        URI uri = UriComponentsBuilder.fromHttpUrl(getApiUrl(apiUrl))
                .queryParam('access_token', access_token)
                .queryParam('openid', openid)
                .queryParam('lang', lang)
                .build()
                .encode("UTF-8")
                .toUri()

        ResponseEntity<InfoResp> respEntity = restTemplate.getForEntity(uri, InfoResp)
        Assert.isTrue(HttpStatus.OK == respEntity.getStatusCode(),
                "调用微信API异常。响应状态码:  ${respEntity.getStatusCode().value()} ")
        Assert.isTrue(respEntity.body as boolean, "微信API响应内容为空")

        InfoResp resp = respEntity.body

        resp.check()

        return resp
    }
}
