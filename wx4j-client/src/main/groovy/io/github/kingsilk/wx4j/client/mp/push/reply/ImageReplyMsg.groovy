package io.github.kingsilk.wx4j.client.mp.push.reply

import io.github.kingsilk.wx4j.client.mp.push.ReplyMsg

/**
 *
 */
class ImageReplyMsg implements ReplyMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "image"
    Long MsgId

    static class Image {

        /**
         * 通过素材管理接口上传多媒体文件，得到的id
         */
        String MediaId
    }
}
