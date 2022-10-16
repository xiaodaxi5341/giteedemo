package cn.cmbchina.seele.common.bo.gitee.request.http.file;

import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 任务
 *
 * @author 韩晓宏IT808481
 * @date 2022/10/14 16:56
 */
public class TaskFileHttpSyncToGiteeRequest extends FileHttpSyncToGiteeRequest {

    @Override
    protected void internalConstructRequestByParams(JSONObject jsonParams, ExtraNecessaryInfo extraInfo) {
        super.internalConstructRequestByParams(jsonParams, extraInfo);
        //自身参数赋值
    }

    @Override
    protected String extractContentFromParams(JSONObject jsonParams) {
        return super.extractContentFromParams(jsonParams);
    }

    @Override
    protected void constructAddRequest(JSONObject jsonParams, ExtraNecessaryInfo extraInfo) {
        //TODO 参数赋值
    }

    @Override
    protected void constructUpdateRequest(JSONObject jsonParams, ExtraNecessaryInfo extraInfo) {
        //TODO 参数赋值
    }

    @Override
    protected void constructDeleteRequest(JSONObject jsonParams, ExtraNecessaryInfo extraInfo) {
        //TODO 参数赋值
    }

    @Override
    public Map<String, Object> convertToHttpParam() {
        return null;
    }
}
