package io.github.kingsilk.wx4j.client.mp.push.msg.event

import io.github.kingsilk.wx4j.client.mp.push.msg.EventMsg

/**
 * 资质认证成功
 */
class QualificationVerifySuccessEvent extends EventMsg {


    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "qualification_verify_success"

    /**
     * 有效期 (整形)，指的是时间戳，将于该时间戳认证过期
     */
    Long ExpiredTime

}
