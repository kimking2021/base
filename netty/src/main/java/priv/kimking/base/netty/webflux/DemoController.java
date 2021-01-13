package priv.kimking.base.netty.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * <p>
 *
 * @author kim
 * @date 2020/9/30
 */
@RestController
public class DemoController {

    @GetMapping("/hello_world")
    public Mono<String> sayHelloWorld() {
        return Mono.just("Hello World");
    }

}
