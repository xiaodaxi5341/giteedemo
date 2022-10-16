package cn.cmbchina.seele.common.bo.gitee.response;

import lombok.Data;

/**
 * 同步码云请求类
 *
 * @author 韩晓宏IT808481
 * @date 2022/10/14 16:49
 */
@Data
public class SyncToGiteeResponse<T> {
    private T data;
    private int code;
    private String desc;

    public static <R> SyncToGiteeResponse<R> simpleSuccess() {
        SyncToGiteeResponse<R> objectSyncToGiteeResponse = new SyncToGiteeResponse<>();
        objectSyncToGiteeResponse.code = 200;
        objectSyncToGiteeResponse.desc = "success";
        return objectSyncToGiteeResponse;
    }
}
