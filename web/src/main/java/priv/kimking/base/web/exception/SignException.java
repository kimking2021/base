package priv.kimking.base.web.exception;

import priv.kimking.base.web.common.enums.ResultCodeEnum;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/17
 */
public class SignException extends RuntimeException {


    public SignException(ResultCodeEnum signInvalid) {
        super();
    }
}
