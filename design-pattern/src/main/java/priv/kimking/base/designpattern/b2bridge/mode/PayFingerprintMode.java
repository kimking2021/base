package priv.kimking.base.designpattern.b2bridge.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kim
 * @date 2021/12/3
 */
public class PayFingerprintMode implements IPayMode {

    private static final Logger log = LoggerFactory.getLogger(PayFingerprintMode.class);

    @Override
    public boolean security(String uId) {
        log.info("指纹支付，风控校验指纹信息");
        return true;
    }

}
