package priv.kimking.base.designpattern.b1adapter.service.impl;

import priv.kimking.base.designpattern.b1adapter.mq.OrderService;
import priv.kimking.base.designpattern.b1adapter.service.OrderAdapterService;

/**
 * @author kim
 * @date 2021/12/3
 */
public class InsideOrderService implements OrderAdapterService {

    private final OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}
