package cn.cmbchina.seele.common.bo.gitee.request.http.file;

import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.bo.gitee.request.http.HttpSyncToGiteeRequest;
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
    private String path;
    /**
     * 文件内容, 要用base64编码
     */
    private String content;
    /**
     * 提交信息
     */
    private String message;
    /**
     * 分支名称。默认为项目对默认分支
     */
    private String branch;
    /**
     * Committer信息
     */
    private Committer committer;
    /**
     * Author信息
     */
    private Author author;
    /**
     * 文件的 Blob Sha,可通过[获取仓库具体路径下的内容]API 获取
     */
    private String sha;

    @Override
    protected void internalConstructRequestByParams(JSONObject jsonParams, ExtraNecessaryInfo extraInfo) {
        super.internalConstructRequestByParams(jsonParams, extraInfo);
    }

    protected String extractContentFromParams(JSONObject jsonParams) {
        return jsonParams.toJSONString();
    }
}