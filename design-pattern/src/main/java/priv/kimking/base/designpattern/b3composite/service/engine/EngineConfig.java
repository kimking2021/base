package priv.kimking.base.designpattern.b3composite.service.engine;

import priv.kimking.base.designpattern.b3composite.service.logic.LogicFilter;
import priv.kimking.base.designpattern.b3composite.service.logic.impl.UserAgeFilter;
import priv.kimking.base.designpattern.b3composite.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kim
 * @date 2021/12/3
 */
public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        EngineConfig.logicFilterMap = logicFilterMap;
    }

}
