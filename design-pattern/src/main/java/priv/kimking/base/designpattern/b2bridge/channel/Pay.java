package priv.kimking.base.designpattern.b2bridge.channel;

import priv.kimking.base.designpattern.b2bridge.mode.IPayMode;

import java.math.BigDecimal;

/**
 * @author kim
 * @date 2021/12/3
 */
public abstract class Pay {

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}
