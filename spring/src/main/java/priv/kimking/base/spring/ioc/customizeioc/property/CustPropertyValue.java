package priv.kimking.base.spring.ioc.customizeioc.property;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/23
 */
public class CustPropertyValue {


    private String name;

    private Object vaule;

    public String getName() {
        return name;
    }

    public Object getVaule() {
        return vaule;
    }

    public CustPropertyValue(String name, Object vaule) {
        this.name = name;
        this.vaule = vaule;
    }

}
