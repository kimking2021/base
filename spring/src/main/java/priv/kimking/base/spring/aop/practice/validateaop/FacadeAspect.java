package priv.kimking.base.spring.aop.practice.validateaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>
 *
 * DEMO:
 *
 * @Facade
 * public TestResponse query(User user) {
 *
 * }
 *
 * @author kim
 * @date 2020/11/9
 */
@Aspect
@Component
public class FacadeAspect {

//    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeAspect.class);
//
//    @Autowired
//    HttpServletRequest request;

    @Around("@annotation(priv.kimking.base.spring.aop.practice.validateaop.Facade)")
    public Object facade(ProceedingJoinPoint pjp) throws Exception {

        Method method = ((MethodSignature)pjp.getSignature()).getMethod();
        Object[] args = pjp.getArgs();
        Class returnType = ((MethodSignature)pjp.getSignature()).getMethod().getReturnType();
        //循环遍历所有参数，进行参数校验
        for (Object parameter : args) {
            try {
                BeanValidator.validateObject(parameter);
            } catch (ValidationException e) {
                return getFailedResponse(returnType, e);
            }
        }
        try {
            // 目标方法执行
            Object response = pjp.proceed();
            return response;
        } catch (Throwable throwable) {
            return getFailedResponse(returnType, throwable);
        }
    }

    /**
     * 定义并返回一个通用的失败响应
     */
    private Object getFailedResponse(Class returnType, Throwable throwable)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

//        //如果返回值的类型为BaseResponse 的子类，则创建一个通用的失败响应
//        if (returnType.getDeclaredConstructor().newInstance() instanceof BaseResponse) {
//            BaseResponse response = (BaseResponse)returnType.getDeclaredConstructor().newInstance();
//            response.setSuccess(false);
//            response.setResponseMessage(throwable.toString());
//            response.setResponseCode(GlobalConstant.BIZ_ERROR);
//            return response;
//        }

//        LOGGER.error(
//                "failed to getFailedResponse , returnType (" + returnType + ") is not instanceof BaseResponse");

        return null;

    }

}
