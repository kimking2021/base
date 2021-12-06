package priv.kimking.base.designpattern.b3composite.service.engine.impl;

import priv.kimking.base.designpattern.b3composite.model.aggregates.TreeRich;
import priv.kimking.base.designpattern.b3composite.model.vo.EngineResult;
import priv.kimking.base.designpattern.b3composite.model.vo.TreeNode;
import priv.kimking.base.designpattern.b3composite.service.engine.EngineBase;

import java.util.Map;

/**
 * @author kim
 * @date 2021/12/3
 */
public class TreeEngineHandle extends EngineBase {

    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }

}
