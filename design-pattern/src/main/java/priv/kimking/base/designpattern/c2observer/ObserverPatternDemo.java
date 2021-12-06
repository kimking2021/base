package priv.kimking.base.designpattern.c2observer;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.kimking.base.designpattern.c2observer.service.LotteryResult;
import priv.kimking.base.designpattern.c2observer.service.LotteryService;
import priv.kimking.base.designpattern.c2observer.service.LotteryServiceImpl;

/**
 * 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。
 * 当一个对象被修改时，则会自动通知依赖它的对象。观察者模式属于行为型模式。
 * <p>
 * 类似事件监听总线，让主线服务与其他辅线业务服务分离，为了使系统降低耦合和增强扩展性，也会使用观察者模式进行处理。
 *
 * @author kim
 * @date 2021/12/6
 */
public class ObserverPatternDemo {

    private static final Logger log = LoggerFactory.getLogger(ObserverPatternDemo.class);

    public static void main(String[] args) {

        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("2765789109876");
        log.info("测试结果：{}", JSONUtil.toJsonStr(result));
    }

}
