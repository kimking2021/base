package priv.kimking.base.web.common.enums;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/12
 */
public enum  ResultCodeEnum {


    /**
     * 自定义消息内容
     */
    CUSTOM(9999, "自定义消息内容"),
    SIGN_INVALID(1002, "签名不合法"),
    /**
     * 参数不合法
     */
    PARAM_ILLEGAL(1001, "参数不合法"),
    /**
     * 成功状态码
     */
    OK(0, "OK"),
    ERROR(1, "ERROR");

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private final int code;

    private final String msg;

}
