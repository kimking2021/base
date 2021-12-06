package priv.kimking.base.designpattern.b7flyweight.service;

import priv.kimking.base.designpattern.b7flyweight.service.util.RedisUtils;

/**
 * @author kim
 * @date 2021/12/6
 */
public class ActivityController {

    private RedisUtils redisUtils = new RedisUtils();

    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        // 模拟从Redis中获取库存变化信息
        Stock stock = new Stock(1000, redisUtils.getStockUsed());
        activity.setStock(stock);
        return activity;
    }

}
