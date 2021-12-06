package priv.kimking.base.designpattern.a3builder;

import priv.kimking.base.designpattern.a3builder.service.Builder;

/**
 * 建造者模式
 * 主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用一定的算法构成；由于需求的变化，这个复杂对象的各个部分经常面临着剧烈的变化，但是将它们组合在一起的算法却相对稳定。
 * <p>
 * 将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。
 *
 * 通过上面对建造者模式的使用，已经可以摸索出一点心得。那就是什么时候会选择这样的设计模式，当：一些基本物料不会变，而其组合经常变化的时候，就可以选择这样的设计模式来构建代码。
 * 设计模式能带给你的是一些思想，但在平时的开发中怎么样清晰的提炼出符合此思路的建造模块，是比较难的。
 *
 * @author kim
 * @date 2021/12/1
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        Builder builder = new Builder();
        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());
        // 轻奢田园
        System.out.println(builder.levelTwo(98.25D).getDetail());
        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());
    }
}
