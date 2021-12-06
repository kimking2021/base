package priv.kimking.base.designpattern.b4decorator.service;

/**
 * @author kim
 * @date 2021/12/6
 */
public class SsoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        return ticket.equals("success");
    }

}
