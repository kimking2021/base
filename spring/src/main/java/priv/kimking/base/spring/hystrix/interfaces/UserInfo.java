package priv.kimking.base.spring.hystrix.interfaces;

// import com.fasterxml.jackson.annotation.JsonIncludeProperties;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/30
 */
// @JsonIncludeProperties(value = {"code", "info", "name", "age", "address"})
public class UserInfo {

    private String code;
    private String info;

    private String name;
    private Integer age;
    private String address;

    public UserInfo() {
    }

    public UserInfo(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public UserInfo(String name, Integer age, String address) {
        this.code = "0000";
        this.info = "success";

        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
