package cn.cmbchina.seele.common.bo.gitee.request.http.user;

import cn.cmbchina.seele.common.bo.gitee.request.http.HttpSyncToGiteeRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 仓库参与人员请求类
 *
 * @author 韩晓宏IT808481
 * @date 2022/10/14 17:01
 */
@Slf4j
@Data
@NoArgsConstructor
public class ProjectUserHttpSyncToGiteeRequest extends HttpSyncToGiteeRequest {

    /**
     * 用户名
     */
    private String username;
    /**
     * 成员权限: 拉代码(pull)，推代码(push)，管理员(admin)。默认: push
     */
    private String permission;

}
