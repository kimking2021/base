package priv.kimking.base.designpattern.a1factory.store.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.kimking.base.designpattern.a1factory.store.service.ICommodity;

import java.util.Map;

/**
 * @author kim
 * @date 2021/12/1
 */
public class CouponCommodityService implements ICommodity {

    private static final Logger log = LoggerFactory.getLogger(CouponCommodityService.class);

    // private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        // CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, extMap);
        // log.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        // if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }

}
