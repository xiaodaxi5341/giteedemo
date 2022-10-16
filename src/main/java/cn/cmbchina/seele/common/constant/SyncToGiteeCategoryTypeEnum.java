package cn.cmbchina.seele.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 同步码云类别枚举类 * *
 *
 * @author 韩晓宏IT808481 *
 * @date 2022/10/14 10:23
 */
@Getter
@AllArgsConstructor
public enum SyncToGiteeCategoryTypeEnum implements CodeEnum {
    REPOSITORY(1, "仓库"),
    FILE(2, "文件"), PROJECT_USER(3, "成员");
    private final Integer code;
    private final String desc;
}