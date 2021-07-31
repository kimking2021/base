package priv.kimking.base.web.handler;

import com.alibaba.excel.EasyExcel;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import priv.kimking.base.web.aop.annotation.ExcelResp;
import priv.kimking.base.web.entity.Excel;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * <p> Spring Web 体系
 *
 * 处理器方法 的 返回值处理
 * 这个切面的缺点是：如果函数没有返回值时，这个接口的代码就不会执行
 *
 * 同级比对：@ResponseBody
 *
 * 在SpringBoot下，默认的ResponseBody处理类就是HandlerMethodReturnValueHandler，
 * 此处理器的优先级比我们新添加的实现类高，在WebMvcConfigurerAdapter 中配置HandlerMethodReturnValueHandler
 *
 * @author kim
 * @date 2021/1/19
 */
public class ExcelReturnValueHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        // System.out.println("HandlerMethodReturnValueHandler process true");
        return methodParameter.hasMethodAnnotation(ExcelResp.class);
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {

        System.out.println("HandlerMethodReturnValueHandler execute");
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);

        // 此处将请求设置为已经处理，将不会继续处理了
//        modelAndViewContainer.setRequestHandled(true);

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        String fileName = URLEncoder.encode("请假列表", StandardCharsets.UTF_8.name());
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Excel.class).sheet("请假列表").doWrite((List) o);
//        response.getWriter()
//                .write("bar");
    }
}
