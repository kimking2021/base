// package priv.kimking.base.spring.rpc.provider;
//
// import kim.kimking.middleware.rpc.annotation.EnableRpc;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.ImportResource;
//
// /**
//  * <p>
//  * todo @ImportResource
//  * Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别；
//  * 想让Spring的配置文件生效，加载进来；@ImportResource标注在一个配置类上。
//  * 注意！这个注解是放在主入口函数的类上，而不是测试类上
//  *
//  * @author kim
//  * @date 2021/9/29
//  */
// @SpringBootApplication
// @Configuration
// @EnableRpc
// @ImportResource(locations = {"classpath:spring-config-provider.xml"})
// public class RpcProviderApplication {
//
//     public static void main(String[] args) {
//         SpringApplication.run(RpcProviderApplication.class, args);
//     }
//
// }
