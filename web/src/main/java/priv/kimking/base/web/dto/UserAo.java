package priv.kimking.base.web.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * <p>
 *
 * @author kim
 * @date 2021/8/11
 */
public class UserAo {

    @NotNull(groups = {UpdateAction.class}, message = "id不能为空")
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Integer age;

    @Valid
    @NotNull
    private Phone phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserAo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}
