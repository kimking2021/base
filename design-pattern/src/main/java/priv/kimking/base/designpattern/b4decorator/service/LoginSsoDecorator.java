package priv.kimking.base.designpattern.b4decorator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kim
 * @date 2021/12/6
 */
public class LoginSsoDecorator extends SsoDecorator {

    private static final Logger log = LoggerFactory.getLogger(LoginSsoDecorator.class);

    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        boolean success = super.preHandle(request, response, handler);
        if (!success) {
            return false;
        }
        String userId = request.substring(8);
        String method = authMap.get(userId);
        log.info("模拟单点登录方法访问拦截校验：{} {}", userId, method);
        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }

}
