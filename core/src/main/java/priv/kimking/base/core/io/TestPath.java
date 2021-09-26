package priv.kimking.base.core.io;

import java.io.File;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/24
 */
public class TestPath {

    public static void main(String[] args) throws Exception {

        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));

        System.out.println(TestPath.class.getClassLoader().getResource(""));

        System.out.println(ClassLoader.getSystemResource(""));

        System.out.println(TestPath.class.getClassLoader().getResource(""));

        System.out.println(TestPath.class.getResource(""));

        System.out.println(TestPath.class.getResource("/"));

        System.out.println(new File("").getAbsolutePath());

        System.out.println(System.getProperty("user.dir"));

    }

}
