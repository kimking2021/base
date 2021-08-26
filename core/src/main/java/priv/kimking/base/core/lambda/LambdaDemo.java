package priv.kimking.base.core.lambda;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/26
 */
public class LambdaDemo {

    public ILambda getLambda(User bar) {
        String foo = "foo";
        return () -> lambdaExpression(foo, bar);
    }

    private String lambdaExpression(String foo, User user) {
        return foo + user.getName();
    }

    public static void main(String[] args) {
        User user = new User("kim");
        LambdaDemo demo = new LambdaDemo();
        ILambda lambda = demo.getLambda(user);
        user.setName("king");
        String result = lambda.lambdaCall();
        System.out.println(result);
    }
}
