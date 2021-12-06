package priv.kimking.base.designpattern.b2bridge.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.kimking.base.designpattern.b2bridge.mode.IPayMode;

import java.math.BigDecimal;

/**
 * @author kim
 * @date 2021/12/3
 */
public class WxPay extends Pay {

    private static final Logger log = LoggerFactory.getLogger(WxPay.class);

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        log.info("模拟微信渠道支付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        log.info("模拟微信渠道支付风控校验。uId：{} tradeId：{} security：{}", uId, tradeId, security);
        if (!security) {
            log.info("模拟微信渠道支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        log.info("模拟微信渠道支付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }
}
