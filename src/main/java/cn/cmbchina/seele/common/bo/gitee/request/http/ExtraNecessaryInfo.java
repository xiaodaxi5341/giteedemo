package cn.cmbchina.seele.common.bo.gitee.request.http;

import cn.cmbchina.seele.common.constant.SyncToGiteeCategoryTypeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeFileTypeEnum;
import cn.cmbchina.seele.common.constant.SyncToGiteeOperateTypeEnum;
import lombok.Data;

/**
 * 其他的一些可以决定最终构建实体的参数信息类 * * @author 韩晓宏IT808481 * @date 2022/10/14 10:54
 */
@Data
public class ExtraNecessaryInfo {
    /**
     * 同步类别
     */
    private SyncToGiteeCategoryTypeEnum categoryType;
    /**
     * 操作类型
     */
    private SyncToGiteeOperateTypeEnum opType;
    /**
     * 文件类型     *     * 同步类别为文件时，不可为空
     */
    private SyncToGiteeFileTypeEnum fileType;
}