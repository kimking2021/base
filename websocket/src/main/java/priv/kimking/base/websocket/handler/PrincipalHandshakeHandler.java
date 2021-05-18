package priv.kimking.base.websocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import priv.kimking.base.websocket.interceptor.AuthHandshakeInterceptor;

import java.security.Principal;
import java.util.Map;

/**
 * <p>
 *
 * @author kim
 * @date 2021/2/1
 */
public class PrincipalHandshakeHandler extends DefaultHandshakeHandler {

    private static final Logger log = LoggerFactory.getLogger(PrincipalHandshakeHandler.class);

    @Nullable
    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        Principal principal = (Principal) attributes.get(AuthHandshakeInterceptor.WS_PRINCIPAL_ATTR_NAME);
        log.info("获取principal: {}", principal);
        return principal;
    }
}
