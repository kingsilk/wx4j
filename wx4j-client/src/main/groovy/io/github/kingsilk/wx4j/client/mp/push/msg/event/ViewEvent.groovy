package io.github.kingsilk.wx4j.client.mp.push.msg.event

import io.github.kingsilk.wx4j.client.mp.push.msg.EventMsg

/**
 * 点击菜单时推送
 *
 * 点击菜单跳转链接时的事件推送
 */
class ViewEvent extends EventMsg {


    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "VIEW"

    /**
     * 事件KEY值，与自定义菜单接口中KEY值对应
     */
    String EventKey
    String MenuId
}
