package priv.kimking.base.core.aop.aspectj;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import priv.kimking.base.core.aop.MethodMatcher;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/24
 */
public class AspectJExpressionPointcut implements MethodMatcher {

    private static final Set<PointcutPrimitive> SUPPORT_PRIMITIVE = new HashSet<>();

    static {
        SUPPORT_PRIMITIVE.add(PointcutPrimitive.EXECUTION);
    }

    private final PointcutExpression expression;

    public AspectJExpressionPointcut(String expressionStr) {
        PointcutParser parser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORT_PRIMITIVE, this.getClass().getClassLoader());
        this.expression = parser.parsePointcutExpression(expressionStr);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return expression.matchesMethodExecution(method).alwaysMatches();
    }
}
