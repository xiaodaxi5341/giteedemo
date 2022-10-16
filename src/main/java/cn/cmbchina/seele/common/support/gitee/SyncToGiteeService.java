package cn.cmbchina.seele.common.support.gitee;

import cn.cmbchina.seele.common.bo.gitee.request.SyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.bo.gitee.response.SyncToGiteeResponse;

/**
 * 同步码云
 *
 * @author 韩晓宏IT808481
 * @date 2022/10/14 17:21
 */
public interface SyncToGiteeService {

    public <T> SyncToGiteeResponse<T> syncCode2Gitee(SyncToGiteeRequest syncToGiteeRequest, ExtraNecessaryInfo necessaryInfo);

}
