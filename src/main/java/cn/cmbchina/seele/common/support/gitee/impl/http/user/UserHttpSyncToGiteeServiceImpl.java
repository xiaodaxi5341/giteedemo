package cn.cmbchina.seele.common.support.gitee.impl.http.user;

import cn.cmbchina.seele.common.bo.gitee.response.SyncToGiteeResponse;
import cn.cmbchina.seele.common.support.gitee.impl.HttpSyncToGiteeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserHttpSyncToGiteeServiceImpl extends HttpSyncToGiteeServiceImpl {

    @Override
    protected <T> SyncToGiteeResponse<T> internalProcessResponse(ResponseEntity<Object> responseEntity) {
        return super.internalProcessResponse(responseEntity);
    }
}
