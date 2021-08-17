package priv.kimking.base.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import priv.kimking.base.web.handler.ExcelReturnValueHandler;
import priv.kimking.base.web.interceptor.SignInterceptor;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author kim
 * @date 2021/1/19
 */
@Configuration
public class WebConfigure extends WebMvcConfigurationSupport {

    @Autowired
    private RequestMappingHandlerAdapter adapter;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void afterPropertiesSet() {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        assert returnValueHandlers != null;
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(returnValueHandlers);
        this.decorateHandlers(handlers);
        adapter.setReturnValueHandlers(handlers);
    }

    private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        for (HandlerMethodReturnValueHandler handler : handlers) {
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                ExcelReturnValueHandler decorator = new ExcelReturnValueHandler();
                int index = handlers.indexOf(handler);
                if (index != -1) {
                    handlers.add(index, decorator);
                } else {
                    handlers.add(decorator);
                }
                break;
            }
        }
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SignInterceptor(objectMapper))
                .addPathPatterns("/api/sign");
        super.addInterceptors(registry);
    }
}
