package priv.kimking.base.designpattern.b1adapter.service;

import cn.hutool.json.JSONUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * MQ消息体适配类
 *
 * 对MQ这样的多种消息体中不同属性同类的值，进行适配再加上代理类，就可以使用简单的配置方式接入对方提供的MQ消息，
 * 而不需要大量重复的开发。非常利于拓展。
 *
 * @author kim
 * @date 2021/12/3
 */
public class MQAdapter {

    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSONUtil.toBean(strJson, Map.class), link);
    }

    public static RebateInfo filter(Map obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        for (String key : link.keySet()) {
            Object val = obj.get(link.get(key));
            RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }

}
