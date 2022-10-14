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
public enum SyncToGiteeOperateTypeEnum implements CodeEnum {
    ADD(1, "新增"),
    UPDATE(2, "更新"),
    DELETE(3, "删除");
    private Integer code;
    private String desc;
}