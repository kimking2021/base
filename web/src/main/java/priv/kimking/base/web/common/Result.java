package priv.kimking.base.web.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import priv.kimking.base.web.common.enums.ResultCodeEnum;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/11
 */
public class Result<T> {

    private int code;
    private String msg;
    // @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private T data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

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

    public static <T> Result<T> fail(ResultCodeEnum resultCodeEnum) {
        Result<T> r = new Result<>();
        r.setCode(resultCodeEnum.getCode());
        r.setMsg(resultCodeEnum.getMsg());
        return r;
    }

    public static <T> Result<T> buildErrorResult(ResultCodeEnum errorCodeEnum) {
        Result<T> r = new Result<>();
        r.setCode(errorCodeEnum.getCode());
        r.setMsg(errorCodeEnum.getMsg());
        return r;
    }


}
