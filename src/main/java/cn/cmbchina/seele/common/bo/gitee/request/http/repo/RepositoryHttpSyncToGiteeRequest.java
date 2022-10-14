package cn.cmbchina.seele.common.bo.gitee.request.http.repo;

import cn.cmbchina.seele.common.bo.gitee.request.http.ExtraNecessaryInfo;
import cn.cmbchina.seele.common.bo.gitee.request.http.HttpSyncToGiteeRequest;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 仓库以http方式同步码云请求类 * * @author 韩晓宏IT808481 * @date 2022/10/13 14:21
 */
@Data
@NoArgsConstructor
public class RepositoryHttpSyncToGiteeRequest extends HttpSyncToGiteeRequest {
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目描述
     */
    private String description;
    /**
     * 项目所在地址
     */
    private String homepage;
    /**
     * 允许提Issue与否。默认: 允许(true)
     */
    private boolean hasIssues = true;
    /**
     * 提供Wiki与否。默认: 提供(true)
     */
    private boolean hasWiki = true;
    /**
     * 组织的路径(path/login)
     */
    private String org;
    /**
     * 项目公开或私有。默认: 公开(false)
     */
    private boolean privated;
    /**
     * 值为true时则会用README初始化仓库。默认: 不初始化(false)
     */
    private boolean autoInit;
    /**
     * Git Ingore模版
     */
    private String gitignoreTemplate;
    /**
     * Git Ingore模版
     */
    private String licenseTemplate;

    @Override
    protected void internalConstructRequestByParams(JSONObject jsonParams, ExtraNecessaryInfo extraInfo) {
        super.internalConstructRequestByParams(jsonParams, extraInfo);
    }
}