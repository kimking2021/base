package priv.kimking.base.netty.webflux;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 *
 * @author kim
 * @date 2020/9/30
 */
@Data
@AllArgsConstructor
public class User {

    private String id;
    private String name;
    private String email;
}
