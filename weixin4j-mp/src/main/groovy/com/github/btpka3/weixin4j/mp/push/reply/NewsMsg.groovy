package com.github.btpka3.weixin4j.mp.push.reply

import com.github.btpka3.weixin4j.mp.push.ReplyMsg

/**
 * 回复图文消息
 */
class NewsMsg implements ReplyMsg {

    String ToUserName
    String FromUserName
    String CreateTime
    final String MsgType = "news"

    /**
     * 图文消息个数，限制为10条以内
     */
    int ArticleCount

    List<Article> articles

    /**
     * 图文消息
     */
    static class Article {

        /**
         * 图文消息标题
         */
        String Title

        /**
         * 图文消息描述
         */
        String Description

        /**
         * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
         */
        String PicUrl

        /**
         * 点击图文消息跳转链接
         */
        String Url
    }
}
