package priv.kimking.base.web.common;

import lombok.Data;
import lombok.ToString;
import priv.kimking.base.web.common.enums.ResultCodeEnum;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/11
 */
@Data
@ToString
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success() {
        Result<T> r = new Result<>();
        r.setCode(0);
        r.setMsg("OK");
        return r;
    }

    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(ResultCodeEnum.OK.getCode());
        r.setMsg(ResultCodeEnum.OK.getMsg());
        r.setData(data);
        return r;
    }

    public static <T> Result<T> fail() {
        Result<T> r = new Result<>();
        r.setCode(1);
        r.setMsg("FAILED");
        return r;
    }

    public static <T> Result<T> buildErrorResult(ResultCodeEnum errorCodeEnum) {
        Result<T> r = new Result<>();
        r.setCode(errorCodeEnum.getCode());
        r.setMsg(errorCodeEnum.getMsg());
        return r;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

}
