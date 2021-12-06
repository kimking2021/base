package priv.kimking.base.designpattern.a5singleton;

import priv.kimking.base.designpattern.a5singleton.service.InnerClassFormat;

/**
 * @author kim
 * @date 2021/12/1
 */
public class SingletonPatternDemo {

    public static void main(String[] args) {
        InnerClassFormat format = InnerClassFormat.getInstance();
    }
}
