package priv.kimking.base.spring.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/29
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:spring-config-consumer.xml"})
public class RpcConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcConsumerApplication.class, args);
    }

}
