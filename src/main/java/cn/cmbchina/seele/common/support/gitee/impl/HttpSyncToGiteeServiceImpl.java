package cn.cmbchina.seele.common.support.gitee.impl;

import cn.cmbchina.seele.common.bo.gitee.request.SyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.request.http.HttpSyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.response.SyncToGiteeResponse;
import cn.cmbchina.seele.common.constant.RestCodeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeErrorDesc;
import cn.cmbchina.seele.common.exception.GlobalException;
import cn.cmbchina.seele.common.support.gitee.SyncToGiteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class HttpSyncToGiteeServiceImpl implements SyncToGiteeService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public SyncToGiteeResponse<?> syncCode2Gitee(SyncToGiteeRequest syncToGiteeRequest) {
        HttpSyncToGiteeRequest httpSyncToGiteeRequest = (HttpSyncToGiteeRequest) syncToGiteeRequest;
        Map<String, Object> params = httpSyncToGiteeRequest.convertToHttpParam();
        ResponseEntity<Object> responseEntity;
        switch (httpSyncToGiteeRequest.getMethod().toUpperCase()) {
            case "GET":
                responseEntity = restTemplate.getForEntity(httpSyncToGiteeRequest.getUrl(), Object.class, params);
                break;
            case "POST":
                responseEntity = restTemplate.postForEntity(httpSyncToGiteeRequest.getUrl(), params, Object.class);
                break;
            default:
                throw new GlobalException(RestCodeEnum.BAD_REQUEST, SyncToGiteeErrorDesc.ERROR_GITEE_HTTP_METHOD);
        }

        return internalProcessResponse(responseEntity);

    }

    protected SyncToGiteeResponse<?> internalProcessResponse(ResponseEntity<Object> responseEntity){
        return SyncToGiteeResponse.simpleSuccess();
    }
}
