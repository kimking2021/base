package priv.kimking.base.designpattern.a1factory.store.service;

import java.util.Map;

/**
 * @author kim
 * @date 2021/12/1
 */
public interface ICommodity {

    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;

}
