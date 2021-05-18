package priv.kimking.base.websocket.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import priv.kimking.base.websocket.message.SockPrincipal;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

/**
 * <p>
 *
 * @author kim
 * @date 2021/2/1
 */
public class AuthHandshakeInterceptor implements HandshakeInterceptor {
    private static final String TOKEN_PARAMETER = "token";
    private static final String TENANT_ID = "tenant";
    public static final String WS_PRINCIPAL_ATTR_NAME = "__wsPrincipal__";
    private static final Logger log = LoggerFactory.getLogger(AuthHandshakeInterceptor.class);

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> attributes) throws Exception {
        HttpServletRequest httpServletRequest = ((ServletServerHttpRequest)serverHttpRequest).getServletRequest();
        String token = httpServletRequest.getParameter(TOKEN_PARAMETER);
        String tenantId = httpServletRequest.getParameter(TENANT_ID);
        log.info("beforeHandshake获取握手验证token: {}", token);
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(tenantId)) {
            return false;
        }
        Principal principal = new SockPrincipal(token, tenantId);
        attributes.put(WS_PRINCIPAL_ATTR_NAME, principal);
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        log.info("afterHandshake握手结束");
    }
}
