package io.github.kingsilk.wx4j.client.mp.push.reply

import io.github.kingsilk.wx4j.client.mp.push.ReplyMsg

/**
 *
 */
class VoiceReplyMsg implements ReplyMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "voice"

    Voice Voice

    public static class Voice {
        /**
         * 通过素材管理接口上传多媒体文件，得到的id
         */
        String MediaId
    }
}
