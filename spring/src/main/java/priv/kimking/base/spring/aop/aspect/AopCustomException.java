package priv.kimking.base.spring.aop.aspect;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/3
 */
public class AopCustomException extends RuntimeException{

    private String code;
    private String msg;

    public AopCustomException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
