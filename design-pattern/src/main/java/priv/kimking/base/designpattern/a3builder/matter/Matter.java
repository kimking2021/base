package priv.kimking.base.designpattern.a3builder.matter;

import java.math.BigDecimal;

/**
 * @author kim
 * @date 2021/12/1
 */
public interface Matter {

    String scene();      // 场景；地板、地砖、涂料、吊顶

    String brand();      // 品牌

    String model();      // 型号

    BigDecimal price();  // 价格

    String desc();       // 描述

}
