package priv.kimking.base.designpattern.a1factory.store.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.kimking.base.designpattern.a1factory.store.service.ICommodity;

import java.util.Map;

/**
 * @author kim
 * @date 2021/12/1
 */
public class GoodsCommodityService implements ICommodity {

    private static final Logger log = LoggerFactory.getLogger(GoodsCommodityService.class);
    // private GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        // DeliverReq deliverReq = new DeliverReq();
        // deliverReq.setUserName(queryUserName(uId));
        // deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        // deliverReq.setSku(commodityId);
        // deliverReq.setOrderId(bizId);
        // deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        // deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        // deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));
        //
        // Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        log.info("请求参数[实物商品] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, extMap);
        // log.info("测试结果[优惠券]：{}", isSuccess);

        // if (!isSuccess) throw new RuntimeException("实物商品发放失败");
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }

}
