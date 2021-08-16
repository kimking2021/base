package priv.kimking.base.web.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/12
 */
@Data
@ToString
public class Phone {

    @NotBlank(groups = {UpdateAction.class}, message = "operatorType不能为空")
    private String operatorType;

    @NotBlank
    private String phoneNumber;

}
