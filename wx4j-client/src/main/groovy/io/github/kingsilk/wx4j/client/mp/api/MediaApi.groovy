package io.github.kingsilk.wx4j.client.mp.api

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.WxMpApi
import io.github.kingsilk.wx4j.client.mp.WxMpApi.BaseReq
import io.github.kingsilk.wx4j.client.mp.WxMpApi.BaseResp
import org.springframework.core.io.Resource

import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

/**
 * 媒体资源相关API
 */
@CompileStatic
interface MediaApi extends WxMpApi {

    final String API_URL_upload = "https://api.weixin.qq.com/cgi-bin/media/upload"
    final String API_URL_getTmp = "https://api.weixin.qq.com/cgi-bin/media/get"
    final String API_URL_uploadImg = "https://api.weixin.qq.com/cgi-bin/media/uploadimg"
    final String API_URL_uploadNews = "https://api.weixin.qq.com/cgi-bin/media/uploadnews"
    final String API_URL_uploadVideo = "https://api.weixin.qq.com/cgi-bin/media/uploadvideo"

    // ----------------------------------------------
    /**
     * 新增临时素材
     *
     * @param type
     *  image - 图片，2M，支持PNG\JPEG\JPG\GIF格式
     *  voice - 语音，2M，播放长度不超过60s，支持AMR\MP3格式，8K采样率
     *  video - 视频，10MB，支持MP4格式
     *  thumb - 缩略图，64KB，支持JPG格式
     */
    UploadResp upload(
            String access_token,
            String type,
            Resource media
    )

    static class UploadResp extends BaseResp {
        String type
        String media_id
        Long created_at
    }

    // ----------------------------------------------
    /**
     * 获取临时素材
     */
    GetResp get(
            String access_token,
            String media_id
    )

    static class GetResp extends BaseResp {
        String type
        String media_id
        Long created_at
    }

    // ----------------------------------------------
    /**
     * 使用FORM表单上传图文消息内的图片获取URL
     *
     * @param access_token 调用接口凭证
     * @param media form-data中媒体文件标识，有filename、filelength、content-type等信息
     */
    UploadImgResp uploadImg(
            String access_token,
            Resource media
    )

    static class UploadImgResp extends BaseResp {
        String url
    }

    // ----------------------------------------------
    UploadNewsResp uploadNews(
            String access_token,
            UploadNewsReq uploadNewsReq
    )

    static class UploadNewsReq extends BaseReq {

        List<Article> articles

        /**
         * 图文消息，一个图文消息支持1到8条图文
         */
        public static class Article {

            /**
             * 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
             */
            String thumb_media_id

            /**
             * 图文消息的作者
             */
            String author

            /**
             * 图文消息的标题
             */
            String title

            /**
             * 在图文消息页面点击“阅读原文”后的页面，受安全限制，如需跳转Appstore，
             * 可以使用itun.es或appsto.re的短链服务，并在短链后增加 #wechat_redirect 后缀。
             */
            String content_source_url

            /**
             * 图文消息页面的内容，支持HTML标签。
             *
             * 具备微信支付权限的公众号，可以使用a标签，
             * 其他公众号不能使用。
             *
             * 如需插入小程序卡片，内容应该是 MpMiniProgram 类对应的XML内容
             */
            String content

            /**
             * 图文消息的描述
             */
            String digest

            /**
             * 是否显示封面.
             * 1 - 显示
             * 0 - 不显示
             */
            Integer show_cover_pic

            @XmlRootElement(name = "data-miniprogram-appid")
            public static class MpMiniProgram {

                @XmlAttribute(name = "data-miniprogram-appid")
                String appid

                @XmlAttribute(name = "data-miniprogram-path")
                String path

                @XmlAttribute(name = "data-miniprogram-title")
                String title

                @XmlAttribute(name = "data-miniprogram-imageurl")
                String imageurl
            }

        }
    }

    static class UploadNewsResp extends BaseResp {

        /**
         * 媒体文件类型
         *
         * image - 图片
         * voice - 语音
         * video - 视频
         * thumb - 缩略图
         * news  - 图文消息
         */
        String type
        String media_id
        Long created_at

    }

    // ----------------------------------------------
    /**
     * 群发视频时，需要通过该接口获取 media_id
     *
     * @param access_token
     * @param uploadVideoReq
     * @return
     */
    UploadVideoResp uploadVideo(
            String access_token, // FIXME
            UploadVideoReq uploadVideoReq
    )

    static class UploadVideoReq extends BaseReq {
        String media_id
        String title
        String description

    }

    static class UploadVideoResp extends BaseResp {
        String type
        String media_id
        Long created_at
    }


}
