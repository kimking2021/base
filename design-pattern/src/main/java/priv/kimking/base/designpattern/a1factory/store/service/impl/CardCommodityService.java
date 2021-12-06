package priv.kimking.base.designpattern.a1factory.store.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.kimking.base.designpattern.a1factory.store.service.ICommodity;

import java.util.Map;

/**
 * @author kim
 * @date 2021/12/1
 */
public class CardCommodityService implements ICommodity {
    private static final Logger log = LoggerFactory.getLogger(CardCommodityService.class);

    // 模拟注入
    // private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        // iQiYiCardService.grantToken(mobile, bizId);
        log.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, extMap);
        // log.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }

}
