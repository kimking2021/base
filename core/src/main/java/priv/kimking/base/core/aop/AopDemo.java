package priv.kimking.base.core.aop;

import priv.kimking.base.core.aop.aspectj.AspectJExpressionPointcut;
import priv.kimking.base.core.aop.bean.IUserService;
import priv.kimking.base.core.aop.bean.UserService;
import priv.kimking.base.core.aop.bean.UserServiceInterceptor;
import priv.kimking.base.core.aop.framework.AdviseSupport;
import priv.kimking.base.core.aop.framework.Cglib2AopProxy;
import priv.kimking.base.core.aop.framework.JdkDynamicAopProxy;

/**
 * <p>
 *
 * href="https://github.com/fuzhengwei/small-spring/tree/main/small-spring-step-11"
 *
 * @author kim
 * @date 2021/8/24
 */
public class AopDemo {

    public static void main(String[] args) {
                // 目标对象
        IUserService userService = new UserService();
        // 组装代理信息
        AdviseSupport advisedSupport = new AdviseSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* priv.kimking.base.core.aop.bean.IUserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }

}
