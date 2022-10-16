package cn.cmbchina.seele.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SyncToGiteeTechTypeEnum implements CodeEnum {

    HTTP(1, "http"),
    JGIT(2, "jgit");
    private final Integer code;
    private final String desc;

}
