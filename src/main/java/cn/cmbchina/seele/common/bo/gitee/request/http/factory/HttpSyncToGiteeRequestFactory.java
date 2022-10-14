package cn.cmbchina.seele.common.bo.gitee.request.http.factory;

import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.bo.gitee.request.http.HttpSyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.request.http.file.TaskFileHttpSyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.request.http.file.WorkflowFileHttpSyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.request.http.repo.RepositoryHttpSyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.request.http.user.ProjectUserHttpSyncToGiteeRequest;
import cn.cmbchina.seele.common.constant.RestCodeEnum;
import cn.cmbchina.seele.common.exception.GlobalException;

/**
 * 根据类别和操作类型生产请求类 * *
 * @author 韩晓宏IT808481 *
 * @date 2022/10/14 15:08
 */
public class HttpSyncToGiteeRequestFactory {

    //TODO 待优化
    public static HttpSyncToGiteeRequest getRequest(ExtraNecessaryInfo extraInfo) {
        HttpSyncToGiteeRequest request;
        switch (extraInfo.getCategoryType()) {
            case REPOSITORY:
                request = new RepositoryHttpSyncToGiteeRequest();
                break;
            case FILE:
                switch (extraInfo.getFileType()) {
                    case TASK:
                        request = new TaskFileHttpSyncToGiteeRequest();
                        break;
                    case WORK_FLOW:
                        request = new WorkflowFileHttpSyncToGiteeRequest();
                        break;
                    default:
                        throw new GlobalException(RestCodeEnum.BAD_REQUEST, "未知的文件类型");
                }
                break;
            case PROJECT_USER:
                request = new ProjectUserHttpSyncToGiteeRequest();
                break;
            default:
                throw new GlobalException(RestCodeEnum.BAD_REQUEST, "未知的码云类别");
        }
        return request;
    }
}