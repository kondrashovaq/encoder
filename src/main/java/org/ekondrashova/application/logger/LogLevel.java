package org.ekondrashova.application.logger;

public enum LogLevel {
    ERROR(10),
    WARN(20),
    INFO(30),
    DEBUG(40),
    TRACE(50);

    private final int order;

    LogLevel(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public boolean isNeedToLog(LogLevel logLevel) {
        return this.getOrder() <= logLevel.getOrder();
    }
}
