package priv.kimking.base.bytecode;

/**
 * <p>
 *
 * @author kim
 * @date 2020/9/15
 */
public class App {


    // javac -g 生成class文件
    // javap -c -l Demo

    // -javaagent:/path/to/logagent.jar

    public static void main(String[] args) throws InterruptedException {
        App apiTest = new App();
        String res01 = apiTest.queryUserInfo(111, 17);
        System.out.println("测试结果：" + res01 + "\r\n");;
    }

    public String queryUserInfo(int uId, int age) throws InterruptedException {
        return "你好, kim | 精神小伙！";
    }

}
