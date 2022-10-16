package cn.cmbchina.seele.common.support.gitee.impl.http.factory;

import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.constant.RestCodeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeErrorDesc;
import cn.cmbchina.seele.common.exception.GlobalException;
import cn.cmbchina.seele.common.support.gitee.SyncToGiteeService;
import cn.cmbchina.seele.common.support.gitee.impl.SyncToGiteeServiceFactory;
import cn.cmbchina.seele.common.support.gitee.impl.http.file.FileHttpSyncToGiteeServiceImpl;
import cn.cmbchina.seele.common.support.gitee.impl.http.repo.RepositoryHttpSyncToGiteeServiceImpl;
import cn.cmbchina.seele.common.support.gitee.impl.http.user.UserHttpSyncToGiteeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HttpSyncToGiteeServiceFactory extends SyncToGiteeServiceFactory {

    @Autowired
    private RepositoryHttpSyncToGiteeServiceImpl repositoryHttpSyncToGiteeService;
    @Autowired
    private FileHttpSyncToGiteeServiceImpl fileHttpSyncToGiteeService;
    @Autowired
    private UserHttpSyncToGiteeServiceImpl userHttpSyncToGiteeService;

    protected SyncToGiteeService internalGetService(ExtraNecessaryInfo extraNecessaryInfo) {
        switch (extraNecessaryInfo.getCategoryType()) {
            case FILE:
                return fileHttpSyncToGiteeService;
            case REPOSITORY:
                return repositoryHttpSyncToGiteeService;
            case PROJECT_USER:
                return userHttpSyncToGiteeService;
            default:
                throw new GlobalException(RestCodeEnum.BAD_REQUEST, SyncToGiteeErrorDesc.UNKNOWN_GITEE_CATEGORY_TYPE);
        }
    }

}
