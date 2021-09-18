package priv.kimking.base.core.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 *
 * SLF4J类似于Commons Logging，也是一个日志接口，而Logback类似于Log4j，是一个日志的实现。
 *
 * 因为对Commons Logging的接口不满意，有人就搞了SLF4J。因为对Log4j的性能不满意，有人就搞了Logback。
 * SLF4J的日志接口传入的是一个带占位符的字符串，用后面的变量自动替换占位符，所以看起来更加自然。
 *
 * 和Log4j类似，我们仍然需要一个Logback的配置文件，把logback.xml放到classpath下
 *
 * @author kim
 * @date 2021/9/18
 */
public class Slf4jLog {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    void foo(int i) {
        log.info("foo: {}", i);
        try {
            int e = 1/i;
        } catch (Exception e) {
            log.error("exception!", e);
        }
    }

    public static void main(String[] args) {
        new Slf4jLog().foo(0);
    }

}
