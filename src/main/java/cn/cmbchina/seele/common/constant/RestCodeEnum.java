package cn.cmbchina.seele.common.constant;

/**
 * 基于http status 的通用rest响应码 * * @author 肖建军IT007370 * @date 2022/1/25 16:26 * @see org.springframework.http.HttpStatus
 */
public enum RestCodeEnum implements CodeEnum {
    /**
     * 成功
     */
    OK(200, "OK"),
    /**
     * 基于客户端请求创建了新的资源后会发送该状态码
     */
    CREATED(201, "Created"),
    /**
     * 客户端的请求不能或者不会被实时地处理， 并且将会在后续被处理。
     */
    ACCEPTED(202, "Accepted"),
    /**
     * 通用的客户端错误状态。通常用于参数异常。
     */
    BAD_REQUEST(400, "Bad Request"),
    /**
     * 客户端在没有提供适当的身份认证凭证的时候向受保护的资源发送请求。
     */
    UNAUTHORIZED(401, "Unauthorized"),
    /**
     * 客户端请求格式正确，但是服务器拒绝执行。一般用于IP限定或者时间限定。
     */
    FORBIDDEN(403, "Forbidden"),
    /**
     * 客户端请求的资源不存在。
     */
    NOT_FOUND(404, "Not Found"),
    /**
     * 客户端请求超时
     */
    REQUEST_TIMEOUT(408, "Request Timeout"),
    /**
     * 客户端请求过多
     */
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    /**
     * 通用的服务器错误响应
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    /**
     * 该API所基于的应用工作并不正常
     */
    SERVICE_UNAVAILABLE(503, "Service Unavailable");
    private final int code;
    private final String msg;

    RestCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.msg;
    }
}