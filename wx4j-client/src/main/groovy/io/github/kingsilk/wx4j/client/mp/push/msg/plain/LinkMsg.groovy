package io.github.kingsilk.wx4j.client.mp.push.msg.plain

import io.github.kingsilk.wx4j.client.mp.push.msg.PlainMsg

/**
 *
 */
class LinkMsg extends PlainMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "link"
    Long MsgId

    /**
     * 消息标题
     */
    String Title

    /**
     * 消息描述
     */
    String Description

    /**
     * 消息链接
     */
    String Url

}
