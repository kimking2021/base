package priv.kimking.base.designpattern.b4decorator.service;

/**
 * @author kim
 * @date 2021/12/6
 */
public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
