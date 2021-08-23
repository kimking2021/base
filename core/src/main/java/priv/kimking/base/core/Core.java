package priv.kimking.base.core;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/16
 */
public class Core {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");

        map.forEach((k, v) -> {
            throw new RuntimeException("xx");
        });
    }
}
