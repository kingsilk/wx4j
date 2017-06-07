package io.github.kingsilk.wx4j.broker.server.store.mongo.domain

import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.CompoundIndexes
import org.springframework.data.mongodb.core.mapping.Document

/**
 * 微信用户信息。
 *
 * 微信 snsapi_userinfo 查询获取的用户信息。
 * 如果没有 snsapi_userinfo scope，则只有 appId, userOpenId 字段有值。
 */
@Document
@CompoundIndexes([
        @CompoundIndex(unique = true, def = "{appId:1,openId:1,lang:1}")
])
class WxUserInfo {

    /**
     * 微信 APP ID
     */
    String appId;

    /**
     * 用户的唯一标识
     */
    String openId;

    /**
     * 语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     */
    String lang;

    /**
     * 用户昵称
     */
    String nickname;

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    String sex;

    /**
     * 用户个人资料填写的省份
     */
    String province;

    /**
     * 普通用户个人资料填写的城市
     */
    String city;

    /**
     * 国家，如中国为CN
     */
    String country;

    /**
     * 用户头像。
     * 最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），
     * 用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    String headImgUrl;

    /**
     * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     */
    Set<String> privilege = new LinkedHashSet<>();

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    String unionId;

    // -------- 以下字段只能通过 用户管理/获取用户基本信息（UnionID机制）获取，也即，只能获取已关注的用户。

    /**
     * 是否已经订阅（关注）。
     */
    boolean subscribe;

    /**
     * 订阅（关注）时间。
     */
    Date subscribeTime;

    /**
     * 公众号运营者对粉丝的备注。
     *
     * 公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     */
    String remark;

    /**
     * 用户所在的分组ID（兼容旧的用户分组接口）
     */
    Integer groupId;

    /**
     * 用户被打上的标签ID列表
     */
    List<Integer> tagIdList;
}
