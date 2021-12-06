package priv.kimking.base.designpattern.c2observer.service.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.kimking.base.designpattern.c2observer.service.LotteryResult;

/**
 * @author kim
 * @date 2021/12/6
 */
public class MessageEventListener implements EventListener {

    private static final Logger log = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        log.info("给用户 {} 发送短信通知(短信)：{}", result.getuId(), result.getMsg());
    }

}
