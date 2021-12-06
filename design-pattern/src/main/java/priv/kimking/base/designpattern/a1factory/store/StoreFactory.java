package priv.kimking.base.designpattern.a1factory.store;

import priv.kimking.base.designpattern.a1factory.store.service.ICommodity;
import priv.kimking.base.designpattern.a1factory.store.service.impl.CardCommodityService;
import priv.kimking.base.designpattern.a1factory.store.service.impl.CouponCommodityService;
import priv.kimking.base.designpattern.a1factory.store.service.impl.GoodsCommodityService;

import java.util.AbstractMap.*;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kim
 * @date 2021/12/1
 */
public class StoreFactory {

    public static Map<Integer, ICommodity> commodityServiceMap = Stream.of(
            new SimpleEntry<>(1, new CouponCommodityService()),
            new SimpleEntry<>(2, new GoodsCommodityService()),
            new SimpleEntry<>(3, new CardCommodityService())
    ).collect(Collectors.toMap(SimpleEntry::getKey,SimpleEntry::getValue));

    public ICommodity getCommodityService(Integer commodityType) {
        ICommodity commodityService = commodityServiceMap.get(commodityType);
        if (commodityService == null) {
            throw new RuntimeException("不存在的商品服务类型");
        }
        return commodityService;
    }

}
