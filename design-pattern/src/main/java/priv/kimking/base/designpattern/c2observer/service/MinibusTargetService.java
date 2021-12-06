package priv.kimking.base.designpattern.c2observer.service;

/**
 * @author kim
 * @date 2021/12/6
 */
public class MinibusTargetService {

    public String lottery(String uId) {
        return Math.abs(uId.hashCode()) % 2 == 0 ? "恭喜你，编码".concat(uId).concat("在本次摇号中签") : "很遗憾，编码".concat(uId).concat("在本次摇号未中签或摇号资格已过期");
    }

}
