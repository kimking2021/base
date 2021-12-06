package priv.kimking.base.designpattern.a2absfactory;

import priv.kimking.base.designpattern.a2absfactory.service.CacheService;
import priv.kimking.base.designpattern.a2absfactory.service.factory.JDKProxy;
import priv.kimking.base.designpattern.a2absfactory.service.factory.impl.EGMCacheAdapter;
import priv.kimking.base.designpattern.a2absfactory.service.factory.impl.IIRCacheAdapter;
import priv.kimking.base.designpattern.a2absfactory.service.impl.CacheServiceImpl;

/**
 * 抽象工厂模式与工厂方法模式虽然主要意图都是为了解决，接口选择问题。但在实现上，抽象工厂是一个中心工厂，创建其他工厂的模式。
 *
 * @author kim
 * @date 2021/12/1
 */
public class AbsFactoryPatternDemo {

    public static void main(String[] args) throws Exception {
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "小傅哥");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println(val01);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "小傅哥");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println(val02);
    }

}
