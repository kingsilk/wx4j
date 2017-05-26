package io.github.btpka3.wx4j.mp.push.msg.plain

import io.github.btpka3.wx4j.mp.push.msg.PlainMsg

/**
 *
 */
class ShortVideoMsg extends PlainMsg {

    /**
     * 图片消息媒体id
     *
     * 只有当  MsgType in ("image","voice","video") 时才有值
     */
    long MediaId

    /**
     * 视频消息缩略图的媒体id
     *
     * 只有当  MsgType in ("video", "shortvideo") 时才有值
     */
    String ThumbMediaId

}