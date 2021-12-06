package priv.kimking.base.designpattern.b1adapter.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kim
 * @date 2021/12/1
 */
public class POPOrderService {

    private static final Logger log = LoggerFactory.getLogger(POPOrderService.class);

    public boolean isFirstOrder(String uId) {
        log.info("POP商家，查询用户的订单是否为首单：{}", uId);
        return true;
    }

}
