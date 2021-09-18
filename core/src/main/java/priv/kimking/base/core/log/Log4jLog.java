package priv.kimking.base.core.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 *
 * Log4j是一种非常流行的日志框架,是一个组件化设计的日志系统,架构大致如下:
 *
 *  log.info("User signed in.");
 *  │
 *  │   ┌──────────┐    ┌──────────┐    ┌──────────┐    ┌──────────┐
 *  ├──>│ Appender │───>│  Filter  │───>│  Layout  │───>│ Console  │
 *  │   └──────────┘    └──────────┘    └──────────┘    └──────────┘
 *  │
 *  │   ┌──────────┐    ┌──────────┐    ┌──────────┐    ┌──────────┐
 *  ├──>│ Appender │───>│  Filter  │───>│  Layout  │───>│   File   │
 *  │   └──────────┘    └──────────┘    └──────────┘    └──────────┘
 *  │
 *  │   ┌──────────┐    ┌──────────┐    ┌──────────┐    ┌──────────┐
 *  └──>│ Appender │───>│  Filter  │───>│  Layout  │───>│  Socket  │
 *      └──────────┘    └──────────┘    └──────────┘    └──────────┘
 *
 *  当我们使用Log4j输出一条日志时，Log4j自动通过不同的Appender把同一条日志输出到不同的目的地。
 *   console：输出到屏幕；
 *   file：输出到文件；
 *   socket：通过网络输出到远程计算机；
 *   jdbc：输出到数据库
 *
 *  在输出日志的过程中，通过Filter来过滤哪些log需要被输出,例如，仅输出ERROR级别的日志。
 *
 *  最后，通过Layout来格式化日志信息，例如，自动添加日期、时间、方法名称等信息。
 *
 *
 *  以XML配置为例，使用Log4j的时候，我们把一个log4j2.xml的文件放到classpath下就可以让Log4j读取配置文件并按照我们的配置来输出日志。
 *
 * @author kim
 * @date 2021/9/18
 */
public class Log4jLog {

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
        new Log4jLog().foo(0);
    }
}
