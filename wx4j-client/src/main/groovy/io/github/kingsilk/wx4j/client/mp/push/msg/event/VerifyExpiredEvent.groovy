package io.github.kingsilk.wx4j.client.mp.push.msg.event

import io.github.kingsilk.wx4j.client.mp.push.msg.EventMsg

/**
 * 认证过期失效通知
 */
class VerifyExpiredEvent extends EventMsg {


    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "verify_expired"

    /**
     * 有效期 (整形)，指的是时间戳，表示已于该时间戳认证过期，需要重新发起微信认证
     */
    Long ExpiredTime

}
