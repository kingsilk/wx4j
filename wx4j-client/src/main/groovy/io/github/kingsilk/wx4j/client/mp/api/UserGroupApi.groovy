package io.github.kingsilk.wx4j.client.mp.api

import groovy.transform.CompileStatic
import io.github.kingsilk.wx4j.client.mp.WxMpApi
import io.github.kingsilk.wx4j.client.mp.WxMpApi.BaseReq
import io.github.kingsilk.wx4j.client.mp.WxMpApi.BaseResp


/**
 * 创建分组
 *
 * 一个公众账号，最多支持创建100个分组。
 */
@CompileStatic
interface UserGroupApi extends WxMpApi {

    final String API_URL_create = "https://api.weixin.qq.com/cgi-bin/groups/create"
    final String API_URL_update = "https://api.weixin.qq.com/cgi-bin/groups/create"
    final String API_URL_del = "https://api.weixin.qq.com/cgi-bin/groups/delete"
    final String API_URL_list = "https://api.weixin.qq.com/cgi-bin/groups/get"
    final String API_URL_findByUser = "https://api.weixin.qq.com/cgi-bin/groups/get"
    final String API_URL_change = "https://api.weixin.qq.com/cgi-bin/groups/members/update"
    final String API_URL_batchChange = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate"

    // ----------------------------------------------
    CreateResp create(
            String access_token,
            CreateReq createReq
    )

    static class CreateReq {
        Group group

        static class Group {
            String name
        }
    }

    static class CreateResp extends BaseResp {
        Group group

        static class Group {
            String id
            String name
        }
    }

    // ----------------------------------------------
    UpdateResp update(
            String access_token,
            UpdateReq createReq
    )

    static class UpdateReq {
        Group group

        static class Group {
            String id
            String name
        }
    }

    static class UpdateResp extends BaseResp {
    }

    // ----------------------------------------------
    DelResp del(
            String access_token,
            DelReq delReq
    )

    static class DelReq {
        Group group

        static class Group {
            String id
        }
    }

    static class DelResp extends BaseResp {}

    // ----------------------------------------------
    ListResp list(
            String access_token
    )

    static class ListResp extends BaseResp {
        List<Group> groups

        static class Group {
            String id
            String name
            int count
        }
    }

    // ----------------------------------------------
    FindByUserResp findByUser(
            String access_token,
            FindByUserReq findByUserReq
    )

    static class FindByUserReq {
        String openid
    }

    static class FindByUserResp extends BaseResp {
        String groupid
    }

    // ----------------------------------------------
    ChangeResp change(
            String access_token,
            ChangeReq changeReq
    )

    static class ChangeReq {
        String openid
        String to_groupid
    }

    static class ChangeResp extends BaseResp {
    }

    // ----------------------------------------------
    BatchChangeResp batchChange(
            String access_token,
            BatchChangeReq batchChangeReq
    )

    static class BatchChangeReq extends BaseReq {

        List<String> openid_list

        String to_groupid
    }

    static class BatchChangeResp extends BaseResp {
    }

}
