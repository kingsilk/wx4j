package io.github.kingsilk.wx4j.client.conf

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.api.AppAtApi
import io.github.kingsilk.wx4j.client.mp.api.JsApiTicketApi
import io.github.kingsilk.wx4j.client.mp.api.SnsUserApi
import io.github.kingsilk.wx4j.client.mp.api.UserAtApi
import io.github.kingsilk.wx4j.client.mp.api.impl.AppAtApiImpl
import io.github.kingsilk.wx4j.client.mp.api.impl.JsApiTicketApiImpl
import io.github.kingsilk.wx4j.client.mp.api.impl.SnsUserApiImpl
import io.github.kingsilk.wx4j.client.mp.api.impl.UserAtApiImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestOperations

/**
 *
 */
@Configuration
@CompileStatic
class WxMpApiConf {

    @Bean
    AppAtApi appAtApiImpl(RestOperations restTemplate) {
        return new AppAtApiImpl(restTemplate)
    }

    @Bean
    JsApiTicketApi jsApiTicketApi(RestOperations restTemplate) {
        return new JsApiTicketApiImpl(restTemplate)
    }

    @Bean
    SnsUserApi snsUserApi(RestOperations restTemplate) {
        return new SnsUserApiImpl(restTemplate)
    }

    @Bean
    UserAtApi userAtApi(RestOperations restTemplate) {
        return new UserAtApiImpl(restTemplate)
    }
}
