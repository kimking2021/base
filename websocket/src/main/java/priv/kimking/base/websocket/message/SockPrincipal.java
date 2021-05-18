package priv.kimking.base.websocket.message;

import java.security.Principal;

/**
 * <p>
 *
 * @author kim
 * @date 2021/1/29
 */
public class SockPrincipal implements Principal {

    private final String loginName;
    private final String tenantId;

    public SockPrincipal(String loginName, String tenantId) {
        this.loginName = loginName;
        this.tenantId = tenantId;
    }

    @Override
    public String getName() {
        return loginName;
    }

    public String getTenantId() {
        return tenantId;
    }

    @Override
    public String toString() {
        return "SockPrincipal{" +
                "loginName='" + loginName + '\'' +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }
}
