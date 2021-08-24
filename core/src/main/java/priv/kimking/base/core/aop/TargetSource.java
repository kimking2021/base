package priv.kimking.base.core.aop;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/24
 */
public class TargetSource {

    private Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public Class<?>[] getInterfaces() {
        return target.getClass().getInterfaces();
    }
}
