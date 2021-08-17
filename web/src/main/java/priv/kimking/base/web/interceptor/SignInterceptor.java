package priv.kimking.base.web.interceptor;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;
import priv.kimking.base.web.common.Result;
import priv.kimking.base.web.common.enums.ResultCodeEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/16
 */
public class SignInterceptor implements HandlerInterceptor {
    
    private static final Logger log = LoggerFactory.getLogger(SignInterceptor.class);

    private final ObjectMapper objectMapper;

    public SignInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("HandlerInterceptor::preHandle  execute");
        String sign = request.getParameter("sign");
        if (StrUtil.isNotBlank(sign)) {
            log.debug("Sign: {}", sign);
            return true;
        }
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Result<?> result = Result.fail(ResultCodeEnum.SIGN_INVALID);

        try (PrintWriter out = response.getWriter()) {
            out.append(objectMapper.writeValueAsString(result));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("HandlerInterceptor::postHandle execute");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("HandlerInterceptor::afterCompletion execute");
    }

}
