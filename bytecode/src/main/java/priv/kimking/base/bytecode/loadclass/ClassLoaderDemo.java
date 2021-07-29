package priv.kimking.base.bytecode.loadclass;

/**
 * <p>
 *
 * @author kim
 * @date 2020/9/16
 */
public class ClassLoaderDemo {

    /**
     * 启动类加载器是用本地代码实现的类加载器，
     * 它负责将JAVA_HOME/lib下面的核心类库或-Xbootclasspath选项指定的jar包等虚拟机识别的类库加载到内存中。
     * 由于启动类加载器涉及到虚拟机本地实现细节，开发者无法直接获取到启动类加载器的引用
     */
    public static void showBootstrapClassLoader() {
        System.out.println(System.getProperty("sun.boot.class.path"));
    }

    /**
     * 扩展类加载器是由Sun的ExtClassLoader（sun.misc.Launcher$ExtClassLoader）实现的，
     * 它负责将JAVA_HOME /lib/ext或者由系统变量-Djava.ext.dir指定位置中的类库加载到内存中。
     * 开发者可以直接使用标准扩展类加载器
     */
    public static void showExtensionClassLoader() {
        System.out.println(System.getProperty("java.ext.dirs"));
    }

    /**
     * 系统类加载器是由 Sun 的 AppClassLoader（sun.misc.Launcher$AppClassLoader）实现的，
     * 它负责将用户类路径(java -classpath或-Djava.class.path变量所指的目录，
     * 即当前类所在路径及其引用的第三方类库的路径，如第四节中的问题6所述)下的类库加载到内存中。
     * 开发者可以直接使用系统类加载器
     */
    public static void showSystemClassLoader() {
        System.out.println(System.getProperty("java.class.path"));
    }

    public static void main(String... args) {
        // app classloader load 加载应用程序classpath目录下的所有jar和class文件
//        System.getProperty("java.class.path");
//        ClassLoader.getSystemClassLoader();

        // ClassLoader appCL = Thread.currentThread().getContextClassLoader();
        // ClassLoader extCL = appCL.getParent();
        // ClassLoader bootCL = extCL.getParent();


        // 显示 启动（Bootstrap）类加载器 加载路径
        // showBootstrapClassLoader();

        // 显示 扩展（Extension）类加载器 加载路径
        // showExtensionClassLoader();

        // 显示 系统（System）类加载器
        showSystemClassLoader();
    }

}
