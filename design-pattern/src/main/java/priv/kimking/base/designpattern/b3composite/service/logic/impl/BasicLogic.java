package priv.kimking.base.designpattern.b3composite.service.logic.impl;

import priv.kimking.base.designpattern.b3composite.model.vo.TreeNodeLink;
import priv.kimking.base.designpattern.b3composite.service.logic.LogicFilter;

import java.util.List;
import java.util.Map;

/**
 * @author kim
 * @date 2021/12/3
 */
public abstract class BasicLogic implements LogicFilter {

    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList) {
        for (TreeNodeLink nodeLine : treeNodeLinkList) {
            if (decisionLogic(matterValue, nodeLine)) {
                return nodeLine.getNodeIdTo();
            }
        }
        return 0L;
    }

    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

    private boolean decisionLogic(String matterValue, TreeNodeLink nodeLink) {
        switch (nodeLink.getRuleLimitType()) {
            case 1:
                return matterValue.equals(nodeLink.getRuleLimitValue());
            case 2:
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
            case 3:
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLink.getRuleLimitValue());
            case 4:
                return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLink.getRuleLimitValue());
            case 5:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLink.getRuleLimitValue());
            default:
                return false;
        }
    }
}
