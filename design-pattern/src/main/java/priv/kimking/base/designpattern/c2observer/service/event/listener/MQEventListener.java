package priv.kimking.base.designpattern.c2observer.service.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.kimking.base.designpattern.c2observer.service.LotteryResult;

/**
 * @author kim
 * @date 2021/12/6
 */
public class MQEventListener implements EventListener {

    private static final Logger log = LoggerFactory.getLogger(MQEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        log.info("记录用户 {} 摇号结果(MQ)：{}", result.getuId(), result.getMsg());
    }

}
