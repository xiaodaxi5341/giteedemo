package cn.cmbchina.seele.common.bo.gitee.request.http.factory;

import cn.cmbchina.seele.common.bo.gitee.request.SyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.constant.RestCodeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeTechTypeEnum;
import cn.cmbchina.seele.common.exception.GlobalException;

public abstract class SyncToGiteeRequestFactory {

    public static SyncToGiteeRequestFactory getRequest(SyncToGiteeTechTypeEnum techType) {
        switch (techType) {
            case HTTP:
                return HttpSyncToGiteeRequestFactory.getInstance();
            case JGIT:
                return JGitSyncToGiteeRequestFactory.getInstance();
            default:
                throw new GlobalException(RestCodeEnum.BAD_REQUEST, "未知的提交码云方式");
        }
    }

    public abstract SyncToGiteeRequest getRequest(ExtraNecessaryInfo extraInfo);

}




