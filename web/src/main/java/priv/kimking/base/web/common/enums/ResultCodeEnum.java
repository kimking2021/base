package priv.kimking.base.web.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/12
 */
@Getter
@AllArgsConstructor
public enum  ResultCodeEnum {


    /**
     * 自定义消息内容
     */
    CUSTOM(9999, "自定义消息内容"),
    /**
     * 参数不合法
     */
    PARAM_ILLEGAL(1001, "参数不合法"),
    /**
     * 成功状态码
     */
    OK(0, "OK"),
    ERROR(1, "ERROR");

    private final int code;

    private final String msg;

}
