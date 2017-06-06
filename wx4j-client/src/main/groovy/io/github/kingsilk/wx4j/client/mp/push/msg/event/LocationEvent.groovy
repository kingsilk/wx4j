package io.github.kingsilk.wx4j.client.mp.push.msg.event

import io.github.kingsilk.wx4j.client.mp.push.msg.EventMsg

/**
 *
 */
class LocationEvent extends EventMsg {

    String ToUserName
    String FromUserName
    Long CreateTime
    final String MsgType = "event"
    final String Event = "LOCATION"

    /**
     * 地理位置纬度
     */
    String Latitude

    /**
     * 地理位置经度
     */
    String Longitude

    /**
     * 地理位置精度
     */
    String Precision
}
