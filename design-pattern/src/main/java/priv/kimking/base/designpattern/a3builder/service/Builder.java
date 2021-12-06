package priv.kimking.base.designpattern.a3builder.service;

import priv.kimking.base.designpattern.a3builder.matter.ceilling.LevelOneCeiling;
import priv.kimking.base.designpattern.a3builder.matter.ceilling.LevelTwoCeiling;
import priv.kimking.base.designpattern.a3builder.matter.coat.DuluxCoat;
import priv.kimking.base.designpattern.a3builder.matter.coat.LiBangCoat;
import priv.kimking.base.designpattern.a3builder.matter.floor.ShengXiangFloor;
import priv.kimking.base.designpattern.a3builder.matter.tile.DongPengTile;
import priv.kimking.base.designpattern.a3builder.matter.tile.MarcoPoloTile;

/**
 * @author kim
 * @date 2021/12/1
 */
public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }

}
