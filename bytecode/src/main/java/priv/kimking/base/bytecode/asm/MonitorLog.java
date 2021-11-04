package priv.kimking.base.bytecode.asm;

/**
 * <p>
 *
 * @author kim
 * @date 2021/11/4
 */
public class MonitorLog {

    public static void info(String name, int... parameters) {
        System.out.println("方法：" + name);
        System.out.println("参数：" + "[" + parameters[0] + "," + parameters[1] + "]");
    }

}
