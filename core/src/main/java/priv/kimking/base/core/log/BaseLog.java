package priv.kimking.base.core.log;

import java.util.logging.Logger;

/**
 * <p>
 *     1. Java标准库内置了日志包java.util.logging
 *
 *     级别：SEVERE WARNING INFO(默认) CONFIG FINE FINER FINEST
 *
 *
 * @author kim
 * @date 2021/9/18
 */
public class BaseLog {

    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");
    }

}
