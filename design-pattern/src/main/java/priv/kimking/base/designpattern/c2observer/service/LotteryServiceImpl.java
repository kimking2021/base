package priv.kimking.base.designpattern.c2observer.service;

import java.util.Date;

/**
 * @author kim
 * @date 2021/12/6
 */
public class LotteryServiceImpl extends LotteryService {

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {
        // 摇号
        String lottery = minibusTargetService.lottery(uId);
        // 结果
        return new LotteryResult(uId, lottery, new Date());
    }

}
