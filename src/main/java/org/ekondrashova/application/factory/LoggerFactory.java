package org.ekondrashova.application.factory;

import org.ekondrashova.application.logger.Logger;

public abstract class LoggerFactory {
    public static Logger getLogger(Class<?> clazz) {
        return new Logger(clazz);
    }
}
