package priv.kimking.base.designpattern.a3builder.service;

import priv.kimking.base.designpattern.a3builder.matter.Matter;

/**
 * @author kim
 * @date 2021/12/1
 */
public interface IMenu {

    IMenu appendCeiling(Matter matter); // 吊顶

    IMenu appendCoat(Matter matter);    // 涂料

    IMenu appendFloor(Matter matter);   // 地板

    IMenu appendTile(Matter matter);    // 地砖

    String getDetail();                 // 明细

}
