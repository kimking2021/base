package priv.kimking.base.designpattern.c3strategy.service;

import java.math.BigDecimal;

/**
 * @author kim
 * @date 2021/12/7
 */
public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }

}
