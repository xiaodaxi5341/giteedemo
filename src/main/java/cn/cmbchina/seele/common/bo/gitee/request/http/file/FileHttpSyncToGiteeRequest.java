package cn.cmbchina.seele.common.bo.gitee.request.http.file;

import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.bo.gitee.request.http.HttpSyncToGiteeRequest;
import cn.cmbchina.seele.common.constant.RestCodeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeErrorDesc;
import cn.cmbchina.seele.common.exception.GlobalException;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 文件以http方式同步码云请求类 * * @author 韩晓宏IT808481 * @date 2022/10/13 14:41
 */
@Data
public class FileHttpSyncToGiteeRequest extends HttpSyncToGiteeRequest {
    /**
     * 文件的路径
     */
    protected String path;
    /**
     * 文件内容, 要用base64编码
     */
    protected String content;
    /**
     * 提交信息
     */
    protected String message;
    /**
     * 分支名称。默认为项目对默认分支
     */
    protected String branch;
    /**
     * Committer信息
     */
    protected Committer committer;
    /**
     * Author信息
     */
    protected Author author;
    /**
     * 文件的 Blob Sha,可通过[获取仓库具体路径下的内容]API 获取
     */
    protected String sha;

    @Override
    protected void internalConstructRequestByParams(JSONObject jsonParams, ExtraNecessaryInfo extraInfo) {
        //TODO 属性赋值
        this.path = "";
        switch (extraInfo.getOpType()) {
            case ADD:
                constructAddRequest(jsonParams, extraInfo);
                break;
            case UPDATE:
                constructUpdateRequest(jsonParams, extraInfo);
                break;
            case DELETE:
                constructDeleteRequest(jsonParams, extraInfo);
                break;
            default:
                throw new GlobalException(RestCodeEnum.BAD_REQUEST, SyncToGiteeErrorDesc.UNKNOWN_GITEE_OP_TYPE);
        }
        this.content = extractContentFromParams(jsonParams);
    }

    protected String extractContentFromParams(JSONObject jsonParams) {
        return jsonParams.toJSONString();
    }
}