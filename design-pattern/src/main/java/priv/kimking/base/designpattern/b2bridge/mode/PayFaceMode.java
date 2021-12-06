package priv.kimking.base.designpattern.b2bridge.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kim
 * @date 2021/12/3
 */
public class PayFaceMode implements IPayMode {

    private static final Logger log = LoggerFactory.getLogger(PayFaceMode.class);

    @Override
    public boolean security(String uId) {
        log.info("人脸支付，风控校验脸部识别");
        return true;
    }

}
