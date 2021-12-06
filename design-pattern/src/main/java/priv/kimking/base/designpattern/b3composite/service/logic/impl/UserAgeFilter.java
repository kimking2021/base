package priv.kimking.base.designpattern.b3composite.service.logic.impl;

import java.util.Map;

/**
 * @author kim
 * @date 2021/12/3
 */
public class UserAgeFilter extends BasicLogic {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }

}
