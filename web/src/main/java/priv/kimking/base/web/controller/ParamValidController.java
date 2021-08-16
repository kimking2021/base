package priv.kimking.base.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import priv.kimking.base.web.common.Result;
import priv.kimking.base.web.dto.UpdateAction;
import priv.kimking.base.web.dto.UserAo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;


/**
 * <p> 参考： https://mp.weixin.qq.com/s/x6_mNdtb6i2XmTiyz4kXrg
 *
 * @author kim
 * @date 2021/8/11
 */
@Slf4j
@RestController
@RequestMapping("/api/param")
@Validated
public class ParamValidController {

    @GetMapping
    public Result<?> getParam() {
        return Result.success();
    }

    /**
     * 如果使用单参数校验，controller类上必须添加@Validated注解
     */
    @DeleteMapping
    public Result<?> deleteById(@NotNull(message = "id不能为空") Long id) {
        log.info("{}", id);
        return Result.success();
    }

    @PostMapping
    public Result<?> addUser(@Validated @RequestBody UserAo userAo) {
        log.info("{}", userAo);
        return Result.success();
    }

    @PutMapping
    public Result<?> updateUser(@Validated({UpdateAction.class, Default.class}) @RequestBody UserAo userAo) {
        log.info("{}", userAo);
        return Result.success();
    }



}
