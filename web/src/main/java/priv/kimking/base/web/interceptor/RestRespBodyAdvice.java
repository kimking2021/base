package priv.kimking.base.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import priv.kimking.base.web.common.Result;

/**
 * <p> Spring MVC 体系， 响应体拦截器
 * <p>
 * Controller层 响应体拦截器
 *
 * @author kim
 * @RestControllerAdvice是@RestController注解的增强，可以实现三个方面的功能： 全局异常处理
 * 全局数据绑定
 * 全局数据预处理
 * @date 2021/1/19
 */
@RestControllerAdvice
public class RestRespBodyAdvice implements ResponseBodyAdvice<Object> {

    private static final Logger log = LoggerFactory.getLogger(RestRespBodyAdvice.class);

    private final ObjectMapper objectMapper;

    @Autowired
    public RestRespBodyAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class httpMessageConverter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (o instanceof String) {
            log.info("字符串返回");
            return objectMapper.writeValueAsString(Result.success(o));
        }
        if (o instanceof Result) {
            return o;
        }
        return Result.success(o);
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class httpMessageConverter) {
        return Boolean.TRUE;
    }

}
