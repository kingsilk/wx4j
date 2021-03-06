package io.github.kingsilk.wx4j.client.mp.push.reply

import io.github.kingsilk.wx4j.client.mp.push.ReplyMsg

/**
 *
 */
class TextReplyMsg implements ReplyMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "text"

    /**
     * 回复的消息内容
     *
     * （换行：在content中能够换行，微信客户端就支持换行显示）
     */
    String Content
}
