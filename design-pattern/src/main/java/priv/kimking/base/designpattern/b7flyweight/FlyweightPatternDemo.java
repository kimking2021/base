package priv.kimking.base.designpattern.b7flyweight;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.kimking.base.designpattern.b7flyweight.service.Activity;
import priv.kimking.base.designpattern.b7flyweight.service.ActivityController;

/**
 * 享元模式（Flyweight Pattern）主要用于减少创建对象的数量，以减少内存占用和提高性能。
 * 如 线程池，连接池
 *
 * 享元模式，主要在于共享通用对象，减少内存的使用，提升系统的访问效率。
 * 而这部分共享对象通常比较耗费内存或者需要查询大量接口或者使用数据库资源，因此统一抽离作为共享对象使用。
 *
 * 享元模式一般情况下使用此结构在平时的开发中并不太多，除了一些线程池、数据库连接池外，再就是游戏场景下的场景渲染。
 *
 * @author kim
 * @date 2021/12/6
 */
public class FlyweightPatternDemo {

    private static final Logger log = LoggerFactory.getLogger(FlyweightPatternDemo.class);

    private static ActivityController activityController = new ActivityController();

    public static void main(String[] args) throws InterruptedException {
        for (int idx = 0; idx < 10; idx++) {
            Long req = 10001L;
            Activity activity = activityController.queryActivityInfo(req);
            log.info("测试结果：{} {}", req, JSONUtil.toJsonStr(activity));
            Thread.sleep(1200);
        }
    }
}
