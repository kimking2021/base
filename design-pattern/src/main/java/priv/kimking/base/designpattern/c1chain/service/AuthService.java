package priv.kimking.base.designpattern.c1chain.service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kim
 * @date 2021/12/6
 */
public class AuthService {

    private static Map<String, Date> authMap = new ConcurrentHashMap<String, Date>();

    public static Date queryAuthInfo(String uId, String orderId) {
        return authMap.get(uId.concat(orderId));
    }

    public static void auth(String uId, String orderId) {
        authMap.put(uId.concat(orderId), new Date());
    }

}
