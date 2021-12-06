package priv.kimking.base.designpattern.a1factory;

import priv.kimking.base.designpattern.a1factory.store.StoreFactory;
import priv.kimking.base.designpattern.a1factory.store.service.ICommodity;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂模式又称工厂方法模式，是一种创建型设计模式，其在父类中提供一个创建对象的方法， 允许子类决定实例化对象的类型。
 * <p>
 * 它的主要意图是定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 * 简单说就是为了提供代码结构的扩展性，屏蔽每一个功能类中的具体实现逻辑。
 *
 * @author kim
 * @date 2021/12/1
 */
public class FactoryPatternDemo {

    public static void main(String[] args) throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        // 1. 优惠券
        ICommodity commodityService_1 = storeFactory.getCommodityService(1);
        commodityService_1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);
        // 2. 实物商品
        ICommodity commodityService_2 = storeFactory.getCommodityService(2);

        Map<String, String> extMap = new HashMap<String, String>();
        extMap.put("consigneeUserName", "谢飞机");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");

        commodityService_2.sendCommodity("10001", "9820198721311", "1023000020112221113", extMap);
        // 3. 第三方兑换卡(爱奇艺)
        ICommodity commodityService_3 = storeFactory.getCommodityService(3);
        commodityService_3.sendCommodity("10001", "AQY1xjkUodl8LO975GdfrYUio", null, null);
    }

}
