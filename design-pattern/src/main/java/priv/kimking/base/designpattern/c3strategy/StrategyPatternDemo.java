package priv.kimking.base.designpattern.c3strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.kimking.base.designpattern.c3strategy.service.Context;
import priv.kimking.base.designpattern.c3strategy.service.event.MJCouponDiscount;
import priv.kimking.base.designpattern.c3strategy.service.event.NYGCouponDiscount;
import priv.kimking.base.designpattern.c3strategy.service.event.ZJCouponDiscount;
import priv.kimking.base.designpattern.c3strategy.service.event.ZKCouponDiscount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式
 * <p>
 * 一般是具有同类可替代的行为逻辑算法场景。\
 * 比如；不同类型的交易方式(信用卡、支付宝、微信)、生成唯一ID策略(UUID、DB自增、DB+Redis、雪花算法、Leaf算法)等，都可以使用策略模式进行行为包装，供给外部使用。
 *
 * @author kim
 * @date 2021/12/7
 */
public class StrategyPatternDemo {

    private static final Logger log = LoggerFactory.getLogger(StrategyPatternDemo.class);

    public static void main(String[] args) {
        Context<Double> context = new Context<Double>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
        log.info("测试结果：直减优惠后金额 {}", discountAmount);

        // 满100减10，商品100元
        Context<Map<String, String>> contextMJ = new Context<Map<String, String>>(new MJCouponDiscount());
        Map<String, String> mapReq = new HashMap<String, String>();
        mapReq.put("x", "100");
        mapReq.put("n", "10");
        BigDecimal discountAmountMJ = contextMJ.discountAmount(mapReq, new BigDecimal(100));
        log.info("测试结果：满减优惠后金额 {}", discountAmountMJ);

        // 折扣9折，商品100元
        Context<Double> contextZK = new Context<Double>(new ZKCouponDiscount());
        BigDecimal discountAmountZK = contextZK.discountAmount(0.9D, new BigDecimal(100));
        log.info("测试结果：折扣9折后金额 {}", discountAmountZK);

        // n元购；100-10，商品100元
        Context<Double> contextNYG = new Context<Double>(new NYGCouponDiscount());
        BigDecimal discountAmountNYG = contextNYG.discountAmount(90D, new BigDecimal(100));
        log.info("测试结果：n元购优惠后金额 {}", discountAmountNYG);

    }

}
