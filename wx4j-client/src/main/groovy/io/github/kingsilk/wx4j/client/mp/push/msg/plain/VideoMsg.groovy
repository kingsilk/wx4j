package io.github.kingsilk.wx4j.client.mp.push.msg.plain

import io.github.kingsilk.wx4j.client.mp.push.msg.PlainMsg

/**
 *
 */
class VideoMsg extends PlainMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "video"
    Long MsgId

    /**
     * 图片消息媒体id
     */
    long MediaId

    /**
     * 视频消息缩略图的媒体id
     */
    String ThumbMediaId


}
