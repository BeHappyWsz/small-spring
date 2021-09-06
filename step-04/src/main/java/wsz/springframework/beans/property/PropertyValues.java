package wsz.springframework.beans.property;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO：
 *
 * @author wsz
 * @desc：
 * @date 2021/9/3
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
        return this;
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
