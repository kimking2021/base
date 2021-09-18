package priv.kimking.base.core.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 *     2. Apache Commons-Logging 日志系统
 *
 *     可以作为“日志接口”来使用。而真正的“日志实现”可以使用Log4j
 *
 *     默认情况下，Commons Loggin自动搜索并使用Log4j（Log4j是另一个流行的日志系统），如果没有找到Log4j，再使用JDK Logging。
 *
 *     级别：FATAL ERROR WARNING INFO DEBUG TRACE
 *
 * @author kim
 * @date 2021/9/18
 */
public class ApacheCommonLog {

    // static final Log log = LogFactory.getLog(ApacheCommonLog.class);
    protected final Log log = LogFactory.getLog(getClass());

    void foo(int i) {
        log.info("foo");
        try {
            int e = 1/i;
        } catch (Exception e) {
            log.error("exception!", e);
        }
    }

    public static void main(String[] args) {
        new ApacheCommonLog().foo(0);
    }
}
