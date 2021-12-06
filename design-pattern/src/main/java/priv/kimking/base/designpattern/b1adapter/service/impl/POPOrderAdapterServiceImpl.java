package priv.kimking.base.designpattern.b1adapter.service.impl;

import priv.kimking.base.designpattern.b1adapter.mq.POPOrderService;
import priv.kimking.base.designpattern.b1adapter.service.OrderAdapterService;

/**
 * @author kim
 * @date 2021/12/3
 */
public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private final POPOrderService popOrderService = new POPOrderService();

    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}
