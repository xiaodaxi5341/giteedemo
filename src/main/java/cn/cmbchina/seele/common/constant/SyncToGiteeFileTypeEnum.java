package cn.cmbchina.seele.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文件类型 * *
 *
 * @author 韩晓宏IT808481 *
 * @date 2022/10/14 11:00
 */
@Getter
@AllArgsConstructor
public enum SyncToGiteeFileTypeEnum implements CodeEnum {
    WORK_FLOW(1, "工作流"),
    TASK(2, "任务");
    private final Integer code;
    private final String desc;
}