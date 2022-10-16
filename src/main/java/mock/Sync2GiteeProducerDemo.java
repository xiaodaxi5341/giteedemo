package mock;

import cn.cmbchina.seele.common.bo.gitee.request.SyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.bo.gitee.request.SyncToGiteeRequestFactory;
import cn.cmbchina.seele.common.bo.gitee.response.SyncToGiteeResponse;
import cn.cmbchina.seele.common.constant.SyncToGiteeCategoryTypeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeFileTypeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeOperateTypeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeTechTypeEnum;
import cn.cmbchina.seele.common.support.gitee.SyncToGiteeService;
import cn.cmbchina.seele.common.support.gitee.impl.SyncToGiteeServiceFactory;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class Sync2GiteeProducerDemo {

    @Autowired
    private SyncToGiteeServiceFactory syncToGiteeServiceFactory;

    public void mock() {
        //监听消息队列，获取到需要的信息
        JSONObject message = getMessageByTopic();
        SyncToGiteeRequestFactory factory = SyncToGiteeRequestFactory.getRequest(SyncToGiteeTechTypeEnum.HTTP);
        ExtraNecessaryInfo extraNecessaryInfo = getExtraNecessaryInfo(message);
        SyncToGiteeRequest request = factory.getRequest(extraNecessaryInfo);
        request.constructRequestByParams(message, extraNecessaryInfo);

        SyncToGiteeService syncToGiteeService = syncToGiteeServiceFactory.getSyncToGiteeService(SyncToGiteeTechTypeEnum.HTTP, extraNecessaryInfo);
        SyncToGiteeResponse<Object> syncToGiteeResponse = syncToGiteeService.syncCode2Gitee(request, extraNecessaryInfo);

        log.info("请求 结束 ： {}", syncToGiteeResponse);
    }

    //自定义额外的必须信息
    protected ExtraNecessaryInfo getExtraNecessaryInfo(JSONObject message) {
        ExtraNecessaryInfo extraNecessaryInfo = new ExtraNecessaryInfo();
        extraNecessaryInfo.setCategoryType(SyncToGiteeCategoryTypeEnum.FILE);
        extraNecessaryInfo.setFileType(SyncToGiteeFileTypeEnum.TASK);
        extraNecessaryInfo.setOpType(SyncToGiteeOperateTypeEnum.ADD);
        return extraNecessaryInfo;
    }

    //轮询表
    protected JSONObject getMessageByTopic() {
        return null;
    }

}
