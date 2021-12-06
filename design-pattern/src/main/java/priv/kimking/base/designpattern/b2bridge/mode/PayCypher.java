package priv.kimking.base.designpattern.b2bridge.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kim
 * @date 2021/12/3
 */
public class PayCypher implements IPayMode {

    private static final Logger log = LoggerFactory.getLogger(PayCypher.class);

    @Override
    public boolean security(String uId) {
        log.info("密码支付，风控校验环境安全");
        return true;
    }

}
