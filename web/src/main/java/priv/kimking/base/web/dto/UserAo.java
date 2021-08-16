package priv.kimking.base.web.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * <p>
 *
 * @author kim
 * @date 2021/8/11
 */
@Data
@ToString
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

}
