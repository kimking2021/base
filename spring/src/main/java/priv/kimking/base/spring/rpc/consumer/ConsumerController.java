package priv.kimking.base.spring.rpc.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.kimking.base.spring.rpc.provider.export.HelloService;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/30
 */
@RestController
public class ConsumerController {

    private static final Logger log = LoggerFactory.getLogger(ConsumerController.class);

    // @Resource
    // private HelloService helloService;

    @GetMapping("/hello")
    public String hi() {
        // return helloService.hi();
        return "";
    }

}
