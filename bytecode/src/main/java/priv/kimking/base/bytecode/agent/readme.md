
## java agent premain
JavaAgent，是一种探针技术可以通过 premain 方法，在类加载的过程中给指定的方法进行字节码增强。
Reference: [https://www.jianshu.com/p/0bbd79661080](https://www.jianshu.com/p/0bbd79661080)
Reference: https://bugstack.cn/itstack-demo-agent

参数 javaagent 可以用于指定一个 jar 包，并且对该 java 包有2个要求：

1. 这个 jar 包的MANIFEST.MF 文件必须指定 Premain-Class 项。
2. Premain-Class 指定的那个类必须实现 premain（）方法。

注：
premain 从字面上理解，就是运行在 main 函数之前的的类,
当Java 虚拟机启动时，在执行 main 函数之前，JVM 会先运行 -javaagent 所指定 jar 包内 Premain-Class 这个类的 premain 方法

参数 agentArgs 时通过命令行传给 Java Agent 的参数， inst 是 Java Class 字节码转换的工具，Instrumentation 常用方法如下：

    void addTransformer(ClassFileTransformer transformer, boolean canRetransform);
    增加一个Class 文件的转换器，转换器用于改变 Class 二进制流的数据，参数 canRetransform 设置是否允许重新转换。

    void redefineClasses(ClassDefinition... definitions) hrows ClassNotFoundException, UnmodifiableClassException;
    在类加载之前，重新定义 Class 文件，ClassDefinition 表示对一个类新的定义，如果在类加载之后，需要使用 retransformClasses 方法重新定义。

    boolean removeTransformer(ClassFileTransformer transformer);
    删除一个类转换器

    void retransformClasses(Class<?>... classes) throws UnmodifiableClassException
    在类加载之后，重新定义 Class。这个很重要，该方法是1.6 之后加入的，事实上，该方法是 update 了一个类。

### 使用方法

1. 定义一个 MANIFEST.MF 文件，必须包含 Premain-Class 选项，通常也会加入Can-Redefine-Classes 和 Can-Retransform-Classes 选项。
2. 创建一个Premain-Class 指定的类，类中包含 premain 方法，方法逻辑由用户自己确定。
3. 将 premain 的类和 MANIFEST.MF 文件打成 jar 包。
4. 使用参数 -javaagent:/jar包路径=[agentArgs 参数] 启动要代理的方法。

注：
在执行以上步骤后，JVM 会先执行 premain 方法，大部分类加载都会通过该方法，
注意：是大部分，不是所有。当然，遗漏的主要是系统类，因为很多系统类先于 agent 执行，而用户类的加载肯定是会被拦截的

### try 

1. 首先定义一个 MANIFEST.MF 文件: MANIFEST.MF
2. 创建一个Premain-Class 指定的类，类中包含 premain 方法: PreMainTraceAgent
3. 将 premain 的类和 MANIFEST.MF 文件打成 jar 包.

### 手动打包

1. javac xxx.java  -> xxx.class -> classdir/xxx.class
2. vim manifest
3. jar -cvfm xxxx.jar /path/to/manifest -C /dir/to/classdir .
4. -javaagent=/path/to/xxxx.jar=[agent args]



## java agent agentmain

1. 定义一个MANIFEST.MF 文件，文件中必须包含 Agent-Class;
2. 创建一个 Agent-Class 指定的类，该类必须包含 agentmain 方法（参数和 premian 相同）。
3. 将MANIFEST.MF 和 Agent 类打成 jar 包;
4. 将 jar 包载入目标虚拟机。目标虚拟机将会自动执行 agentmain 方法执行方法逻辑，同时，ClassFileTransformer 也会长期有效，在每一个类加载器加载 Class 的时候都会拦截。

