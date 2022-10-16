package mock;

import cn.cmbchina.seele.common.bo.gitee.request.SyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.bo.gitee.request.http.factory.SyncToGiteeRequestFactory;
import cn.cmbchina.seele.common.constant.SyncToGiteeCategoryTypeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeFileTypeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeOperateTypeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeTechTypeEnum;
import com.alibaba.fastjson.JSONObject;

public class Sync2GiteeProducerDemo {

    public void mock(){
        //监听消息队列，获取到需要的信息
        JSONObject message = getMessageByTopic();
        SyncToGiteeRequestFactory factory = SyncToGiteeRequestFactory.getRequest(SyncToGiteeTechTypeEnum.HTTP);
        ExtraNecessaryInfo extraNecessaryInfo = getExtraNecessaryInfo(message);
        SyncToGiteeRequest request = factory.getRequest(extraNecessaryInfo);
        request.constructRequestByParams(message,extraNecessaryInfo);


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
    protected JSONObject getMessageByTopic(){

    }

}
