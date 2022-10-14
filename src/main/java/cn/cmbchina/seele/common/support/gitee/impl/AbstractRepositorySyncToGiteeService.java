package cn.cmbchina.seele.common.support.gitee.impl;

import cn.cmbchina.seele.common.bo.gitee.request.SyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.response.SyncToGiteeResponse;
import cn.cmbchina.seele.common.support.gitee.SyncToGitee;

/**
 * 同步码云仓库服务接口
 *
 * @author 韩晓宏IT808481
 * @date 2022/10/14 17:25
 */
public abstract class AbstractRepositorySyncToGiteeService implements SyncToGitee {

    @Override
    public SyncToGiteeResponse syncCode2Gitee(SyncToGiteeRequest syncToGiteeRequest) {
        return null;
    }
}
