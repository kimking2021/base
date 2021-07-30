package priv.kimking.base.core.proxy;

/**
 * <p> 动态代理: JDK动态代理 和 cglib
 *
 * jdk创建对象的速度远大于cglib，这是由于cglib创建对象时需要操作字节码。
 * cglib执行速度略大于jdk，所以比较适合单例模式。
 * 另外由于CGLIB的大部分类是直接对Java字节码进行操作，这样生成的类会在Java的永久堆中。
 * 如果动态代理操作过多，容易造成永久堆满，触发OutOfMemory异常。spring默认使用jdk动态代理，如果类没有接口，则使用cglib。
 *
 * @author kim
 * @date 2021/7/29
 */
public class Demo {
}
