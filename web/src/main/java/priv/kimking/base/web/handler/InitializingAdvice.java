//package priv.kimking.base.web.handler;
//
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * <p>
// *
// * @author kim
// * @date 2021/1/19
// */
//@Configuration
//public class InitializingAdvice implements InitializingBean {
//
//    private final RequestMappingHandlerAdapter adapter;
//
//    public InitializingAdvice(RequestMappingHandlerAdapter adapter) {
//        this.adapter = adapter;
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
//
//        List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>();
//        newHandlers.add(new ExcelResponseBody());
//        assert returnValueHandlers != null;
//        newHandlers.addAll(returnValueHandlers);
//        adapter.setReturnValueHandlers(newHandlers);
//    }
//}
