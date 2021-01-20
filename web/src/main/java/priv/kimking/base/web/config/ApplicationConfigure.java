package priv.kimking.base.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import priv.kimking.base.web.handler.ExcelResponseBody;

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
public class ApplicationConfigure extends WebMvcConfigurationSupport {

//    @Autowired
//    private RequestMappingHandlerAdapter adapter;
//
//    @PostConstruct
//    public void afterPropertiesSet() {
//        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
//        assert returnValueHandlers != null;
//        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(returnValueHandlers);
//        this.decorateHandlers(handlers);
//        adapter.setReturnValueHandlers(handlers);
//    }
//
//    private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {
//        for (HandlerMethodReturnValueHandler handler : handlers) {
//            if (handler instanceof RequestResponseBodyMethodProcessor) {
//                ExcelResponseBody decorator = new ExcelResponseBody();
//                int index = handlers.indexOf(handler);
//                if (index != -1) {
//                    handlers.add(index, decorator);
//                } else {
//                    handlers.add(decorator);
//                }
//                break;
//            }
//        }
//    }




}
