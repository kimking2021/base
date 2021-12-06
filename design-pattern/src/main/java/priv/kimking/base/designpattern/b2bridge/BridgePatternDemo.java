package priv.kimking.base.designpattern.b2bridge;

import priv.kimking.base.designpattern.b2bridge.channel.Pay;
import priv.kimking.base.designpattern.b2bridge.channel.WxPay;
import priv.kimking.base.designpattern.b2bridge.channel.ZfbPay;
import priv.kimking.base.designpattern.b2bridge.mode.PayFaceMode;
import priv.kimking.base.designpattern.b2bridge.mode.PayFingerprintMode;

import java.math.BigDecimal;

/**
 * 桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。
 * 通过提供抽象化和实现化之间的桥接结构，来实现二者的解耦。
 * <p>
 * <p>
 * 核心实现也就是在A类中含有B类接口，通过构造函数传递B类的实现，这个B类就是设计的桥。
 *
 * @author kim
 * @date 2021/12/3
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
    }

}
