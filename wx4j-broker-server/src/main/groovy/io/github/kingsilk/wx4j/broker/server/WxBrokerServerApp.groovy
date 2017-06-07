package io.github.kingsilk.wx4j.broker.server

import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 *
 */
@SpringBootApplication
@CompileStatic
class WxBrokerServerApp {

    static void main(String[] args) throws Exception {
        SpringApplication.run(WxBrokerServerApp.class, args)
    }

}
