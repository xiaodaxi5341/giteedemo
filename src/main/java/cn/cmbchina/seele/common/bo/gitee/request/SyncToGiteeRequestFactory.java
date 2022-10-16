package cn.cmbchina.seele.common.bo.gitee.request;

import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.bo.gitee.request.http.factory.HttpSyncToGiteeRequestFactory;
import cn.cmbchina.seele.common.bo.gitee.request.jgit.factory.JGitSyncToGiteeRequestFactory;
import cn.cmbchina.seele.common.constant.RestCodeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeErrorDesc;
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
                throw new GlobalException(RestCodeEnum.BAD_REQUEST, SyncToGiteeErrorDesc.UNKNOWN_GITEE_PUSH_TYPE);
        }
    }

    public abstract SyncToGiteeRequest getRequest(ExtraNecessaryInfo extraInfo);

}




