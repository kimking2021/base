package priv.kimking.base.designpattern.c3strategy.service.event;

import priv.kimking.base.designpattern.c3strategy.service.ICouponDiscount;

import java.math.BigDecimal;

/**
 * N元购
 * @author kim
 * @date 2021/12/7
 */
public class NYGCouponDiscount implements ICouponDiscount<Double> {

    /**
     * n元购购买
     * 1. 无论原价多少钱都固定金额购买
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }

}
