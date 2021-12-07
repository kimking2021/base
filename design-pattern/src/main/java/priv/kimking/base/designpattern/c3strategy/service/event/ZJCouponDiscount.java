package priv.kimking.base.designpattern.c3strategy.service.event;

import priv.kimking.base.designpattern.c3strategy.service.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author kim
 * @date 2021/12/7
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {

    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     * 2. 最低支付金额1元
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }

}
