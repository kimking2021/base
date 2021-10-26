package priv.kimking.base.spring.rpc.provider.export;

import priv.kimking.base.spring.rpc.provider.export.domain.Hi;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/29
 */
public interface HelloService {

    String hi();

    String say(String str);

    String sayHi(Hi hi);

}
