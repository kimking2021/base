package priv.kimking.base.core.lambda;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/26
 */
public class LambdaDemo {

    public ILambda getLambda(String foo) {
        String bar = "bar";
        return () -> lambdaExpression(foo, bar);
    }

    private String lambdaExpression(String foo, String bar) {
        return foo + bar;
    }

    public static void main(String[] args) {
        LambdaDemo demo = new LambdaDemo();
        ILambda lambda = demo.getLambda("foo");
        String result = lambda.lambdaCall();
        System.out.println(result);
    }
}
