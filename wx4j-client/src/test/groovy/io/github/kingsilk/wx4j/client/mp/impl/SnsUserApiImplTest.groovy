package io.github.kingsilk.wx4j.client.mp.impl

import io.github.kingsilk.wx4j.client.BaseTest
import io.github.kingsilk.wx4j.client.mp.api.SnsUserApi.InfoResp
import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat

/**
 *
 */
class SnsUserApiImplTest extends BaseTest {


    @Test
    void info01() {


        // 请先执行 UserAtImplTest#getUserAt01()
        String openid = "opp7G0xuI_HXWWCxrQpNEiTZ9pmI"
        String userAt = utUtils.getUserAt("wxTest2", openid)
        assertThat(userAt).isNotNull()

        InfoResp resp = snsUserApi.info(userAt, openid, null)

        log.debug("resp = " + resp)
        assertThat(resp).isNotNull()
        assertThat(resp.errcode == null || resp.errcode == 0).isTrue()
        assertThat(resp.nickname).isNotNull()
        assertThat(resp.headimgurl).isNotNull()
    }
}
