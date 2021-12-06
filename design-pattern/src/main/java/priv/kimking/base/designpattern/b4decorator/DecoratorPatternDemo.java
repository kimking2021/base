package priv.kimking.base.designpattern.b4decorator;

import priv.kimking.base.designpattern.b4decorator.service.LoginSsoDecorator;
import priv.kimking.base.designpattern.b4decorator.service.SsoInterceptor;

/**
 * 装饰器模式
 * 向一个现有的对象添加新的功能，同时又不改变其结构
 * 创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。
 * <p>
 * 主要解决的是直接继承下因功能的不断横向扩展导致子类膨胀的问题，
 * 而是用装饰器模式后就会比直接继承显得更加灵活同时这样也就不再需要考虑子类的维护。
 *
 * @author kim
 * @date 2021/12/6
 */
public class DecoratorPatternDemo {

    public static void main(String[] args) {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }
}
