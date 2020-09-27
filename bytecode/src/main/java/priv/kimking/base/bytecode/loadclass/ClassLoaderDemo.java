package priv.kimking.base.bytecode.loadclass;

/**
 * <p>
 *
 * @author kim
 * @date 2020/9/16
 */
public class ClassLoaderDemo {

    public static void main(String... args) {
        // bootstrap classloader  load
//        System.out.println(System.getProperty("sun.boot.class.path"));

        // extension classloader load
//        System.out.println(System.getProperty("java.ext.dirs"));

        // app classloader load 加载应用程序classpath目录下的所有jar和class文件
//        System.getProperty("java.class.path");
//        ClassLoader.getSystemClassLoader();

        ClassLoader appCL = Thread.currentThread().getContextClassLoader();
        ClassLoader extCL = appCL.getParent();
        ClassLoader bootCL = extCL.getParent();



    }

}
