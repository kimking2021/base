package priv.kimking.base.spring.aop.practice.validateaop;


import javax.validation.constraints.NotNull;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/9
 */
public class User {

    private String idempotentNo;

    @NotNull(message = "userName can't be null")
    private String userName;

}
