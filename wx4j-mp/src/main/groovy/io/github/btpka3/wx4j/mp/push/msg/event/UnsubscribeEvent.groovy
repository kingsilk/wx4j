package io.github.kingsilk.wx4j.mp.push.msg.event

import io.github.kingsilk.wx4j.mp.push.msg.EventMsg

/**
 * 取消关注事件
 *
 */
class UnsubscribeEvent extends EventMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "unsubscribe"
}
