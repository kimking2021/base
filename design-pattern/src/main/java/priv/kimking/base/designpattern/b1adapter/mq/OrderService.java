package priv.kimking.base.designpattern.b1adapter.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kim
 * @date 2021/12/1
 */
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public long queryUserOrderCount(String userId){
        log.info("自营商家，查询用户的订单是否为首单：{}", userId);
        return 10L;
    }

}
