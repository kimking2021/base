package priv.kimking.base.compiler;

/**
 * <p> 词法分析有限状态机状态枚举
 *
 * @author kim
 * @date 2021/5/18
 */
public enum DfaState {

    /**
     * 初始状态
     */
    Initial,
    /**
     * 标识符状态
     */
    Id,
    /**
     * 数字字面量状态
     */
    IntLiteral,
    /**
     * 操作符状态
     */
    Operator

}
