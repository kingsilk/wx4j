package io.github.kingsilk.wx4j.client.conf

import groovy.transform.CompileStatic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *
 */
@Configuration
@CompileStatic
class CommonConf {

    @Bean
    Map testMap() {
        return new LinkedHashMap()
    }

//    @Bean
//    UtProps utProps() {
//        return new UtProps()
//    }

}
