package io.github.kingsilk.wx4j.client.qy.push.msg.plain

import io.github.kingsilk.wx4j.client.qy.push.msg.PlainMsg


/**
 *
 */
class TextMsg extends PlainMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "text"
    Long MsgId
    Long AgentID

    /**
     * 文本消息内容
     */
    String Content


}
