package io.github.kingsilk.wx4j.client.mp.impl

import io.github.kingsilk.wx4j.client.BaseTest
import io.github.kingsilk.wx4j.client.mp.api.JsApiTicketApi
import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat

/**
 *
 */
class JsApiTicketApiImplTest extends BaseTest {


    @Test
    void getTicket01() {

        String at = utUtils.getWxMpAt("wxTest2")
        JsApiTicketApi.GetTicketResp resp = jsApiTicketApi.getTicket(at)

        log.debug("resp = " + resp)
        assertThat(resp).isNotNull()
        assertThat(resp.errcode == null || resp.errcode == 0).isTrue()
        assertThat(resp.ticket).isNotNull()
    }
}
