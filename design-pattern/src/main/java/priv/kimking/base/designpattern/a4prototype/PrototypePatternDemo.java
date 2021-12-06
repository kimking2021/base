package priv.kimking.base.designpattern.a4prototype;

import priv.kimking.base.designpattern.a4prototype.service.QuestionBankController;

/**
 * 原型模式
 * 这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式。
 * <p>
 * 原型模式主要解决的问题就是创建重复对象，而这部分对象内容本身比较复杂，生成过程可能从库或者RPC接口中获取数据的耗时较长，因此采用克隆的方式节省时间。
 *
 * 原型模式的使用频率确实不是很高。如果有一些特殊场景需要使用到，也可以按照此设计模式进行优化。
 *
 * 便于通过克隆方式创建复杂对象、也可以避免重复做初始化操作、不需要与类中所属的其他类耦合等。但也有一些缺点如果对象中包括了循环引用的克隆，以及类中深度使用对象的克隆，都会使此模式变得异常麻烦。
 *
 *
 * @author kim
 * @date 2021/12/1
 */
public class PrototypePatternDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("花花", "1000001921032"));
        System.out.println(questionBankController.createPaper("豆豆", "1000001921051"));
        System.out.println(questionBankController.createPaper("大宝", "1000001921987"));
    }
}
