package priv.kimking.base.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.kimking.base.web.common.Result;

/**
 * <p>
 *
 * @author kim
 * @date 2021/8/17
 */
@RestController
@RequestMapping("/api/sign")
public class SignController {

    private static final Logger log = LoggerFactory.getLogger(SignController.class);
    
    @GetMapping
    public Result<?> get() {
        log.info("sing get request accept");
        return Result.success();
    }

}
