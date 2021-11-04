
## ASM 字节码编程
ASM，是一个 Java 字节码操控框架。asm 是直接使用指令来控制字节码。
它能被用来动态生成类或者增强既有类的功能。ASM 可以直接产生二进制 class 文件，也可以在类被加载入 Java 虚拟机之前动态改变类行为。
另外除了 asm 可以操作字节码，还有javassist和Byte-code等，他们比 asm 要简单，但是执行效率还是 asm 高。
Reference: https://github.com/fuzhengwei/itstack-demo-bytecode
Reference: https://bugstack.cn/itstack-demo-agent

#### 利用 ASM 插件进行字节码编程
```shell script
# 反解析下类, 查看汇编指令
javac Hello
javap -c Hello

public class priv.kimking.base.bytecode.asm.Hello {
  public priv.kimking.base.bytecode.asm.Hello();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String hello
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}

```
注：
getstatic	    获取静态字段的值
ldc	            常量池中的常量值入栈
invokevirtual	运行时方法绑定调用方法
return	        void函数返回

#### 在原有方法上字节码增强监控耗时

