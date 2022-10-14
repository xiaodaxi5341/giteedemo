package cn.cmbchina.seele.common.bo.gitee.request.http;

import cn.cmbchina.seele.common.bo.gitee.request.SyncToGiteeRequest;
import cn.cmbchina.seele.common.bo.gitee.request.http.user.ProjectUserHttpSyncToGiteeRequest;
import cn.cmbchina.seele.common.constant.RestCodeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeCategoryTypeEnum;
import cn.cmbchina.seele.common.exception.GlobalException;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * http方式同步码云请求类 * *
 * @author 韩晓宏IT808481 *
 * @date 2022/10/13 11:43
 */
@Slf4j
@Data
@NoArgsConstructor
public class HttpSyncToGiteeRequest extends SyncToGiteeRequest {
    /**
     * 请求路径
     */
    protected String url;
    /**
     * 请求类型
     */
    protected String method;
    /**
     * 码云授权
     */
    protected String accessToken;
    /**
     * 项目所属个性地址(企业、组织或个人的地址path)
     */
    protected String owner;
    /**
     * 项目路径
     */
    protected String repo;

    @Override
    public void constructRequestByParams(JSONObject jsonParams, ExtraNecessaryInfo extraInfo) {
        if (validate(extraInfo)) {
            internalConstructRequestByParams(jsonParams, extraInfo);
        }
    }

    /**
     * 参数为空校验     *     * @param extraInfo     * @return
     */
    private boolean validate(ExtraNecessaryInfo extraInfo) {
        if (extraInfo == null || extraInfo.getCategoryType() == null || extraInfo.getOpType() == null || (extraInfo.getCategoryType() == SyncToGiteeCategoryTypeEnum.FILE && extraInfo.getFileType() == null)) {
            return false;
        }
        return true;
    }

    /**
     * 通过模板构建具体的请求类，此处决定码云类别     *     * @param jsonParams 从消息队列中获取到的参数信息     * @param extraInfo  构建具体请求类所需的一些额外参数     * @return
     */
    protected void internalConstructRequestByParams(JSONObject jsonParams, ExtraNecessaryInfo extraInfo) {
    }
}