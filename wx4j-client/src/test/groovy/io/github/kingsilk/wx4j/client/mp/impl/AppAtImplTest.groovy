package io.github.kingsilk.wx4j.client.mp.impl

import io.github.kingsilk.wx4j.client.BaseTest
import io.github.kingsilk.wx4j.client.mp.api.AppAtApi
import io.github.kingsilk.wx4j.client.mp.api.AppAtApi.GetAppAtResp
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import static org.assertj.core.api.Assertions.assertThat

/**
 *
 */
class AppAtImplTest extends BaseTest {

    @Autowired
    AppAtApi appAtApi

    @Test
    void getAppAt01() {
        String appId = utProps.wx.wxTest2.appId
        String appSecret = utProps.wx.wxTest2.appSecret

        GetAppAtResp resp = appAtApi.getAppAt(appId, appSecret)

        log.debug("resp = " + resp)
        assertThat(resp).isNotNull()
        assertThat(resp.errcode == null || resp.errcode == 0).isTrue()
        assertThat(resp.access_token).isNotNull()
    }
}
