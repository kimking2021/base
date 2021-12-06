package priv.kimking.base.designpattern.b3composite.service.engine;

import priv.kimking.base.designpattern.b3composite.model.aggregates.TreeRich;
import priv.kimking.base.designpattern.b3composite.model.vo.EngineResult;

import java.util.Map;

/**
 * @author kim
 * @date 2021/12/3
 */
public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}
