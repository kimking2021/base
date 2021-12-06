package priv.kimking.base.designpattern.c1chain;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.kimking.base.designpattern.c1chain.service.AuthLink;
import priv.kimking.base.designpattern.c1chain.service.AuthService;
import priv.kimking.base.designpattern.c1chain.service.impl.Level1AuthLink;
import priv.kimking.base.designpattern.c1chain.service.impl.Level2AuthLink;
import priv.kimking.base.designpattern.c1chain.service.impl.Level3AuthLink;

import java.text.ParseException;
import java.util.Date;

/**
 * 责任链模式（Chain of Responsibility Pattern）为请求创建了一个接收者对象的链。
 * <p>
 * 对请求的发送者和接收者进行解耦。这种类型的设计模式属于行为型模式。
 *
 * @author kim
 * @date 2021/12/6
 */
public class ChainPatternDemo {

    private static final Logger log = LoggerFactory.getLogger(ChainPatternDemo.class);

    public static void main(String[] args) throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000013", "王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                        .appendNext(new Level1AuthLink("1000011", "段总")));

        log.info("测试结果：{}", JSONUtil.toJsonStr(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        log.info("测试结果：{}", "模拟三级负责人审批，王工");
        log.info("测试结果：{}", JSONUtil.toJsonStr(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        log.info("测试结果：{}", "模拟二级负责人审批，张经理");
        log.info("测试结果：{}", JSONUtil.toJsonStr(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        log.info("测试结果：{}", "模拟一级负责人审批，段总");
        log.info("测试结果：{}", JSONUtil.toJsonStr(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

    }
}
