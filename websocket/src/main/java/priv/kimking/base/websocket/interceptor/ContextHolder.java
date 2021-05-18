package priv.kimking.base.websocket.interceptor;

/**
 * <p>
 *
 * @author kim
 * @date 2021/2/1
 */

public class ContextHolder {

    private static final ThreadLocal<String> CONTEXT = new ThreadLocal<>();
    
    public static void setKey(String key) {
        CONTEXT.set(key);
    }
    
    public static String getKey() {
        return CONTEXT.get();
    }
    
    public static void clear() {
        CONTEXT.remove();
    }
}
