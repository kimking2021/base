package priv.kimking.base.web.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <p> Spring MVC 体系， 响应体拦截器
 *
 *     Controller层 响应体拦截器
 *
 * @author kim
 * @date 2021/1/19
 */
@RestControllerAdvice
public class RestRespBodyIntercepter implements ResponseBodyAdvice {

    private final String INTERCEPTER_METHOD_NAME = "foo";

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        System.out.println("TestResponseBodyAdvice==>beforeBodyWrite:" + o.toString() + ","
                + methodParameter);
        o = "bar";
        return o;
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        System.out.println("resp body interceptor support?");
        return INTERCEPTER_METHOD_NAME.equals(methodParameter.getMethod().getName());
    }

}
