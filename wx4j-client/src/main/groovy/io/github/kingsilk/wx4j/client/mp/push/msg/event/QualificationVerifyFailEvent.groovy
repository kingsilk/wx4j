package io.github.kingsilk.wx4j.client.mp.push.msg.event

import io.github.kingsilk.wx4j.client.mp.push.msg.EventMsg

/**
 * 资质认证失败
 */
class QualificationVerifyFailEvent extends EventMsg {


    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "qualification_verify_fail"

    /**
     * 失败发生时间 (整形)，时间戳
     */
    Long FailTime

    /**
     * 认证失败的原因
     */
    String FailReason

}
