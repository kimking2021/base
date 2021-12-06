package priv.kimking.base.designpattern.b3composite.model.aggregates;

import priv.kimking.base.designpattern.b3composite.model.vo.TreeNode;
import priv.kimking.base.designpattern.b3composite.model.vo.TreeRoot;

import java.util.Map;

/**
 * 规则树聚合
 *
 * @author kim
 * @date 2021/12/3
 */
public class TreeRich {

    private TreeRoot treeRoot;                          //树根信息
    private Map<Long, TreeNode> treeNodeMap;        //树节点ID -> 子节点

    public TreeRich(TreeRoot treeRoot, Map<Long, TreeNode> treeNodeMap) {
        this.treeRoot = treeRoot;
        this.treeNodeMap = treeNodeMap;
    }

    public TreeRoot getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRoot treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNode> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNode> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }

}
