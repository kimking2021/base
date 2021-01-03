package priv.kimking.base.spring.ioc.customizeioc.property;

import priv.kimking.base.spring.ioc.customizeioc.property.CustPropertyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author kim
 * @date 2020/11/23
 */
public class CustPropertyValues {
    private List<CustPropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(CustPropertyValue propertyValue) {
        propertyValues.add(propertyValue);
    }

    public List<CustPropertyValue> getPropertyValues() {
        return propertyValues;
    }

}
