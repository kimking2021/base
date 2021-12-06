package priv.kimking.base.designpattern.c2observer.service.event.listener;

import priv.kimking.base.designpattern.c2observer.service.LotteryResult;

/**
 * @author kim
 * @date 2021/12/6
 */
public interface EventListener {

    void doEvent(LotteryResult result);

}
