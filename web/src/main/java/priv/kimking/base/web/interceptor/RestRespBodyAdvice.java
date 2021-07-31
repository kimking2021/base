package priv.kimking.base.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class RestRespBodyAdvice implements ResponseBodyAdvice {

    private static final Logger log = LoggerFactory.getLogger(RestRespBodyAdvice.class);

    private final String INTERCEPTER_METHOD_NAME = "fooFoo";

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class httpMessageConverter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

//        System.out.println("TestResponseBodyAdvice==>beforeBodyWrite:" + o.toString() + ","
//                + methodParameter);
        System.out.println("ResponseBodyAdvice execute");
        o = "bar";
        return o;
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class httpMessageConverter) {
        // System.out.println("ResponseBodyAdvice support?");
        // log.info("{}, {}", methodParameter.getMethod().getName(), httpMessageConverter.getName());
        return INTERCEPTER_METHOD_NAME.equals(methodParameter.getMethod().getName());
    }

}
