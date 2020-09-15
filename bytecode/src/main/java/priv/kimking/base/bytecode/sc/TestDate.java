package priv.kimking.base.bytecode.sc;

import java.util.Date;

/**
 * <p>
 *
 * @author kim
 * @date 2020/9/15
 */
public class TestDate {

    private int count = 0;

    public static void main(String[] args) {
        TestDate testDate = new TestDate();
        testDate.test1();
    }

    public void test1(){
        Date date = new Date();
        String name1 = "wangerbei";
        test2(date,name1);
        System.out.println(date+name1);
    }

    public void test2(Date dateP,String name2){
        dateP = null;
        name2 = "zhangsan";
    }

    public void test3(){
        count++;
    }

    public void  test4(){
        int a = 0;
        {
            int b = 0;
            b = a+1;
        }
        int c = a+1;
    }

}
// javap -c -l TestDate 字节码反汇编
/**
 *
 * public class priv.kimking.base.bytecode.sc.TestDate {
 *
 *   //默认的构造方法，在构造方法执行时主要完成一些初始化操作，包括一些成员变量的初始化赋值等操作
 *   public priv.kimking.base.bytecode.sc.TestDate();
 *     Code:
 *        0: aload_0                           //从本地变量表中加载索引为0的变量的值，也即this的引用，压入栈
 *        1: invokespecial #1                  //出栈，调用 Method java/lang/Object."<init>":()V 初始化对象，就是this指定的对象的init()方法完成初始化
 *        4: aload_0                           // 4到6表示，调用this.count = 0，也即为count复制为0。这里this引用入栈
 *        5: iconst_0                          //将常量0，压入到操作数栈
 *        6: putfield      #2                  //出栈前面压入的两个值（this引用，常量值0）， 将0取出，并赋值给count     Field count:I
 *        9: return
 *     //指令与代码行数的偏移对应关系，每一行第一个数字对应代码行数，第二个数字对应前面code中指令前面的数字
 *     LineNumberTable:
 *       line 11: 0
 *       line 13: 4
 *     //局部变量表，start+length表示这个变量在字节码中的生命周期起始和结束的偏移位置（this生命周期从头0到结尾10），slot就是这个变量在局部变量表中的槽位（槽位可复用），name就是变量名称，Signatur局部变量类型描述
 *     LocalVariableTable:
 *       Start  Length  Slot  Name   Signature
 *           0      10     0  this   Lpriv/kimking/base/bytecode/sc/TestDate;
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        // new指令，创建一个class com/justest/test/TestDate对象，new指令并不能完全创建一个对象，对象只有在初，只有在调用初始化方法完成后（也就是调用了invokespecial指令之后），对象才创建成功,
 *        0: new           #3                  //创建对象，并将对象引用压入栈 // class priv/kimking/base/bytecode/sc/TestDate
 *        3: dup                               //将操作数栈定的数据复制一份，并压入栈，此时栈中有两个引用值
 *        4: invokespecial #4                  //pop出栈引用值,调用其构造函数，完成对象的初始化 // Method "<init>":()V
 *        7: astore_1                          //pop出栈引用值，将其（引用）赋值给局部变量表中的变量testDate
 *        8: aload_1                           //将testDate的引用值压入栈，因为testDate.test1();调用了testDate，这里使用aload_1从局部变量表中获得对应的变量testDate的值并压入操作数栈
 *        9: invokevirtual #5                  //引用出栈，调用testDate的test1()方法 // Method test1:()V
 *       12: return                            //整个main方法结束返回
 *     LineNumberTable:
 *       line 16: 0
 *       line 17: 8
 *       line 18: 12
 *     //局部变量表，testDate只有在创建完成并赋值后，才开始声明周期
 *     LocalVariableTable:
 *       Start  Length  Slot  Name   Signature
 *           0      13     0  args   [Ljava/lang/String;
 *           8       5     1 testDate   Lpriv/kimking/base/bytecode/sc/TestDate;
 *
 *   public void test1();
 *     Code:
 *        0: new           #6                  // class java/util/Date
 *        3: dup
 *        4: invokespecial #7                  // Method java/util/Date."<init>":()V
 *        7: astore_1
 *        8: ldc           #8                  // String wangerbei，将常量“wangerbei”压入栈 // String wangerbei
 *       10: astore_2
 *       11: aload_0
 *       12: aload_1
 *       13: aload_2
 *       14: invokevirtual #9                  // Method test2:(Ljava/util/Date;Ljava/lang/String;)V
 *       17: getstatic     #10                 // Field java/lang/System.out:Ljava/io/PrintStream;
 *       20: new           #11                 // class java/lang/StringBuilder
 *       23: dup
 *       24: invokespecial #12                 // Method java/lang/StringBuilder."<init>":()V
 *       27: aload_1
 *       28: invokevirtual #13                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
 *       31: aload_2
 *       32: invokevirtual #14                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *       35: invokevirtual #15                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 *       38: invokevirtual #16                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *       41: return
 *     LineNumberTable:
 *       line 21: 0
 *       line 22: 8
 *       line 23: 11
 *       line 24: 17
 *       line 25: 41
 *     LocalVariableTable:
 *       Start  Length  Slot  Name   Signature
 *           0      42     0  this   Lpriv/kimking/base/bytecode/sc/TestDate;
 *           8      34     1  date   Ljava/util/Date;
 *          11      31     2 name1   Ljava/lang/String;
 *
 *   public void test2(java.util.Date, java.lang.String);
 *     Code:
 *        0: aconst_null
 *        1: astore_1
 *        2: ldc           #17                 // String zhangsan
 *        4: astore_2
 *        5: return
 *     LineNumberTable:
 *       line 28: 0
 *       line 29: 2
 *       line 30: 5
 *     LocalVariableTable:
 *       Start  Length  Slot  Name   Signature
 *           0       6     0  this   Lpriv/kimking/base/bytecode/sc/TestDate;
 *           0       6     1 dateP   Ljava/util/Date;
 *           0       6     2 name2   Ljava/lang/String;
 *
 *   public void test3();
 *     Code:
 *        0: aload_0
 *        1: dup
 *        2: getfield      #2                  // Field count:I
 *        5: iconst_1
 *        6: iadd
 *        7: putfield      #2                  // Field count:I
 *       10: return
 *     LineNumberTable:
 *       line 33: 0
 *       line 34: 10
 *     LocalVariableTable:
 *       Start  Length  Slot  Name   Signature
 *           0      11     0  this   Lpriv/kimking/base/bytecode/sc/TestDate;
 *
 *   public void test4();
 *     Code:
 *        0: iconst_0
 *        1: istore_1
 *        2: iconst_0
 *        3: istore_2
 *        4: iload_1
 *        5: iconst_1
 *        6: iadd
 *        7: istore_2
 *        8: iload_1
 *        9: iconst_1
 *       10: iadd
 *       11: istore_2
 *       12: return
 *     LineNumberTable:
 *       line 37: 0
 *       line 39: 2
 *       line 40: 4
 *       line 42: 8
 *       line 43: 12
 *     LocalVariableTable:
 *       Start  Length  Slot  Name   Signature
 *           4       4     2     b   I
 *           0      13     0  this   Lpriv/kimking/base/bytecode/sc/TestDate;
 *           2      11     1     a   I
 *          12       1     2     c   I
 * }
 *
 */