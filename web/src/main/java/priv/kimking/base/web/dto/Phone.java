package priv.kimking.base.web.dto;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/12
 */
public class Phone {

    @NotBlank(groups = {UpdateAction.class}, message = "operatorType不能为空")
    private String operatorType;

    @NotBlank
    private String phoneNumber;

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "operatorType='" + operatorType + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
