package cn.cmbchina.seele.common.support.gitee.impl;

import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.constant.RestCodeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeErrorDesc;
import cn.cmbchina.seele.common.constant.SyncToGiteeTechTypeEnum;
import cn.cmbchina.seele.common.exception.GlobalException;
import cn.cmbchina.seele.common.support.gitee.SyncToGiteeService;
import cn.cmbchina.seele.common.support.gitee.impl.http.factory.HttpSyncToGiteeServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SyncToGiteeServiceFactory {

    @Autowired
    private HttpSyncToGiteeServiceFactory httpSyncToGiteeServiceFactory;

    private SyncToGiteeServiceFactory getSyncToGiteeServiceFactory(SyncToGiteeTechTypeEnum type) {
        switch (type) {
            case HTTP:
                return httpSyncToGiteeServiceFactory;
            case JGIT:
                return null;
            default:
                throw new GlobalException(RestCodeEnum.BAD_REQUEST, SyncToGiteeErrorDesc.UNKNOWN_GITEE_PUSH_TYPE);
        }
    }

    public SyncToGiteeService getSyncToGiteeService(SyncToGiteeTechTypeEnum type, ExtraNecessaryInfo extraNecessaryInfo) {
        return Objects.requireNonNull(getSyncToGiteeServiceFactory(type)).internalGetService(extraNecessaryInfo);
    }

    protected SyncToGiteeService internalGetService(ExtraNecessaryInfo extraNecessaryInfo){
        return null;
    }

}
