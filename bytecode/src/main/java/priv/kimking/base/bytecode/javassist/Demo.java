package priv.kimking.base.bytecode.javassist;

import javassist.*;

import java.lang.reflect.Method;

/**
 * <p> javassist 字节码生成
 *
 * 官方文档： http://www.javassist.org/tutorial/tutorial.html
 * 参考资料： https://www.cnblogs.com/rickiyang/p/11336268.html
 *
 *
 * 1. ClassPool 会在内存中维护所有被它创建过的 CtClass，当 CtClass 数量过多时，会占用大量的内存，
 *    API中给出的解决方案是 有意识的调用CtClass的detach()方法以释放内存
 *
 * 2. ClassPool.getDefault : 返回默认的ClassPool 是单例模式的，一般通过该方法创建我们的ClassPool；
 *
 * 3. ClassPool.appendClassPath, ClassPool.insertClassPath : 将一个ClassPath加到类搜索路径的末尾位置 或 插入到起始位置。
 *    通常通过该方法写入额外的类搜索路径，以解决多个类加载器环境中找不到类的尴尬；
 *
 * 4. ClassPool.toClass : 将修改后的CtClass加载至当前线程的上下文类加载器中，CtClass的toClass方法是通过调用本方法实现。
 *    需要注意的是一旦调用该方法，则无法继续修改已经被加载的class；
 *
 * 5. ClassPool.get , ClassPool.getCtClass : 根据类路径名获取该类的CtClass对象，用于后续的编辑。
 *
 *
 * CtClass需要关注的方法：
 *
 *     freeze : 冻结一个类，使其不可修改；
 *     isFrozen : 判断一个类是否已被冻结；
 *     prune : 删除类不必要的属性，以减少内存占用。调用该方法后，许多方法无法将无法正常使用，慎用；
 *     defrost : 解冻一个类，使其可以被修改。如果事先知道一个类会被defrost， 则禁止调用 prune 方法；
 *     detach : 将该class从ClassPool中删除；
 *     writeFile : 根据CtClass生成 .class 文件；
 *     toClass : 通过类加载器加载该CtClass。
 *
 *
 * CtMethod中的一些重要方法：
 *
 *     insertBefore : 在方法的起始位置插入代码；
 *     insterAfter : 在方法的所有 return 语句前插入代码以确保语句能够被执行，除非遇到exception；
 *     insertAt : 在指定的位置插入代码；
 *     setBody : 将方法的内容设置为要写入的代码，当方法被 abstract修饰时，该修饰符被移除；
 *     make : 创建一个新的方法。
 *
 * @author kim
 * @date 2021/7/26
 */
public class Demo {

    private static final ClassPool POOL = ClassPool.getDefault();

    public static void createPersonClass() throws Exception {

         // 1. 创建一个空类
        // ClassPool pool = ClassPool.getDefault();
        CtClass cc = POOL.makeClass("priv.kimking.base.bytecode.javassist.Person");

        // 2. 新增一个字段 private String name;
        // 字段名为name
        CtField param = new CtField(POOL.get("java.lang.String"), "name", cc);
        param.setModifiers(Modifier.PRIVATE);
        cc.addField(param, CtField.Initializer.constant("kim"));

        // 3.生成getter,setter 方法
        cc.addMethod(CtNewMethod.setter("setName", param));
        cc.addMethod(CtNewMethod.getter("getName", param));

        // 4.无参构造函数
        CtConstructor cons = new CtConstructor(new CtClass[]{}, cc);
        cons.setBody("{name = \"kimking\";}");
        cc.addConstructor(cons);

        // 5. 添加有参的构造函数
        cons = new CtConstructor(new CtClass[]{POOL.get("java.lang.String")}, cc);
        cons.setBody("{$0.name = $1;}");
        cc.addConstructor(cons);

        // 6. 创建一个名为printName方法，无参数，无返回值，输出name值
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "printName", new CtClass[]{}, cc);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(name);}");
        cc.addMethod(ctMethod);

        //将这个创建的类对象编译为.class文件
        // cc.writeFile("/Users/jeanroy/src/myproject/base/bytecode/src/main/java");


    }

    // 通过反射使用生成的字节码
    public static void usePersonClassViaReflect() throws Exception {
        // 设置类路径
        // POOL.appendClassPath("/Users/jeanroy/src/myproject/base/bytecode/src/main/java");
        CtClass cc = POOL.get("priv.kimking.base.bytecode.javassist.Person");

        // 通过类加载器加载该CtClass
        Object person = cc.toClass().newInstance();
        Method setName = person.getClass().getMethod("setName", String.class);
        setName.invoke(person, "kk");

        Method printName = person.getClass().getMethod("printName");
        printName.invoke(person);
    }

    // 通过接口使用生成的字节码
    public static void usePersonClassViaInterface() throws Exception {
        CtClass personInterface = POOL.get("priv.kimking.base.bytecode.javassist.IPerson");
        CtClass ctClass = POOL.get("priv.kimking.base.bytecode.javassist.Person");
        ctClass.setInterfaces(new CtClass[]{personInterface});

        IPerson person = (IPerson) ctClass.toClass().newInstance();
        person.setName("kk");
        person.printName();
    }

    public static void modifyPersonService() throws Exception {

        CtClass ctClass = POOL.get("priv.kimking.base.bytecode.javassist.PersonService");
        CtMethod ctMethod = ctClass.getDeclaredMethod("personFly");
        ctMethod.insertBefore("System.out.println(\"起飞之前准备。。。\");");
        ctMethod.insertAfter("System.out.println(\"成功落地\");");

        CtMethod newMethod = new CtMethod(CtClass.voidType, "joinFriend", new CtClass[]{}, ctClass);
        newMethod.setModifiers(Modifier.PUBLIC);
        newMethod.setBody("{System.out.println(\"i wanna be ur friends\");}");
        ctClass.addMethod(newMethod);

        Object personService = ctClass.toClass().newInstance();
        Method personFly = personService.getClass().getMethod("personFly");
        personFly.invoke(personService);
        Method joinFriend = personService.getClass().getMethod("joinFriend");
        joinFriend.invoke(personService);

    }

    public static void main(String[] args) {
        try {
            // // 生成字节码并使用
            // createPersonClass();
            // // usePersonClassViaReflect();
            // usePersonClassViaInterface();


            //  修改现有的类对象
            modifyPersonService();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
