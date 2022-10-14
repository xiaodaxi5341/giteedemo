package cn.cmbchina.seele.common.exception;

import cn.cmbchina.seele.common.constant.CodeEnum;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 全局 exception, 本系统中的所有自定义 exception 都应该由此派生, 以便 GlobalExceptionHandler 进行捕获 * <li>堆栈输出格式： ERROR_NAME{code=500， desc="异常信息"， details="异常详细信息"}</> * * <li>details加载优先级：高优先级将覆盖低优先级</> * <li>1. 指定details</> * <li>2. cause.getMessage()</> * <li>3. CodeEnum.getDesc()</>
 */
@ToString
@Getter
@Slf4j
public class GlobalException extends RuntimeException {
    private CodeEnum codeEnum;
    private Integer code;
    private String name;
    private String desc;
    private String details;

    /**
     * 使用CodeEnum.getDesc()作为异常详细信息。 {@link CodeEnum#getDesc()}     *     * <li>该方法不log原始堆栈</>     *     * @param codeEnum 异常枚举 {@link CodeEnum}
     */
    public GlobalException(CodeEnum codeEnum) {
        this(codeEnum, null, codeEnum.getDesc());
    }

    /**
     * 使用cause.getMessage()作为异常详细信息。     *     * <li>log 出原始堆栈</>     *     * @param codeEnum 异常枚举 {@link CodeEnum}     * @param cause 原始堆栈
     */
    public GlobalException(CodeEnum codeEnum, Throwable cause) {
        this(codeEnum, cause, cause.getMessage());
    }

    public GlobalException(CodeEnum codeEnum, String details) {
        this(codeEnum, null, details);
    }

    public GlobalException(CodeEnum codeEnum, Throwable cause, String details) {
        this(codeEnum.name(), codeEnum.getCode(), codeEnum.getDesc(), cause, details);
        this.codeEnum = codeEnum;
    }

    /**
     * <p>该构造禁止业务代码调用</>     *     * @param name 异常名称 {@link CodeEnum#name()}     * @param code 异常码 {@link CodeEnum#getCode()}     * @param desc 异常码描述 {@link CodeEnum#getDesc()}     * @param details 异常详细信息，作为异常补充说明     * @param cause 原始堆栈
     */
    public GlobalException(String name, Integer code, String desc, Throwable cause, String details) {
        super(String.format("%s{code=%s, desc=%s, details=%s}", name, code, desc, details), cause);
        this.code = code;
        this.name = name;
        this.desc = desc;
        this.details = details;
    }
}