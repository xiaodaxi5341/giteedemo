package cn.cmbchina.seele.common.bo.gitee.request;

import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import com.alibaba.fastjson.JSONObject;

/**
 * 同步码云请求类 * * @author 韩晓宏IT808481 * @date 2022/10/13 11:42
 */
public abstract class SyncToGiteeRequest {
    /**
     * 构建同步码云请求参数，对外隐藏具体实现细节     *
     *
     * @param jsonParams 从消息队列中获取到的参数信息     *
     * @param extraInfo  一些确定具体处理方案的参数
     */
    public abstract void constructRequestByParams(JSONObject jsonParams, ExtraNecessaryInfo extraInfo);
}