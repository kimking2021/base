package priv.kimking.base.core.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 *     cglib的原理是这样，它生成一个继承B的类型C（代理类），这个代理类持有一个MethodInterceptor，我们setCallback时传入的。
 *     代理类重写所有被代理类中的方法（方法名一致），然后在代理类中，构建名叫“CGLIB”+“$父类方法名$”的方法（下面叫cglib方法，所有非private的方法都会被构建），
 *     方法体里只有一句话super.方法名()，可以简单的认为保持了对父类方法的一个引用，方便调用。
 *
 *     C中就有了重写方法、cglib方法、父类方法（不可见），还有一个统一的拦截方法（增强方法intercept）。
 *     其中重写方法和cglib方法肯定是有映射关系的。
 *
 * 参考： https://blog.csdn.net/flyfeifei66/article/details/81481222
 *
 * @author kim
 * @date 2021/7/30
 */
public class CglibProxy implements MethodInterceptor {

     // 根据一个类型产生代理类，此方法不要求一定放在MethodInterceptor中
    public Object creatProxyedObj(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();
    }

    /**
     * 代理类的重写方法是外界调用的入口（LSP原则），它调用MethodInterceptor的intercept方法，
     *
     * 第一个参数传递的是this，代表代理类本身，第二个参数标示拦截的方法，第三个参数是入参，第四个参数是cglib方法，intercept方法完成增强后，我们调用cglib方法间接调用父类方法完成整个方法链的调用
     * @param arg0  代表代理类本身
     * @param arg1 拦截的方法
     * @param arg2 入参
     * @param arg3 cglib方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        // 这里增强
        System.out.println("pre-handle");
        // cglib采用了fastclass机制，不仅巧妙的避开了调不到父类方法的问题，还加速了方法的调用。
        // fastclass基本原理是，给每个方法编号，通过编号找到方法执行避免了通过反射调用
        return arg3.invokeSuper(arg0, arg2);
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Target proxy = (Target) cglibProxy.creatProxyedObj(Target.class);
        proxy.fly();
    }

}
