package org.ekondrashova.application.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static LogLevel logLevel;
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
    private final Class<?> clazz;

    static {
        logLevel = LogLevel.INFO;
    }

    public Logger(Class<?> clazz) {
        this.clazz = clazz;
    }

    public static void setLogLevel(LogLevel logLevel) {
        Logger.logLevel = logLevel;
    }

    public void trace(String log, Object... args) {
        if (LogLevel.TRACE.isNeedToLog(logLevel)) {
            log(log, args, LogLevel.TRACE);
        }
    }

    public void debug(String log, Object... args) {
        if (LogLevel.DEBUG.isNeedToLog(logLevel)) {
            log(log, args, LogLevel.DEBUG);
        }
    }

    public void info(String log, Object... args) {
        if (LogLevel.INFO.isNeedToLog(logLevel)) {
            log(log, args, LogLevel.INFO);
        }
    }

    public void warn(String log, Object... args) {
        if (LogLevel.WARN.isNeedToLog(logLevel)) {
            log(log, args, LogLevel.WARN);
        }
    }

    public void error(String log, Object... args) {
        if (LogLevel.ERROR.isNeedToLog(logLevel)) {
            log(log, args, LogLevel.ERROR);
        }
    }

    private void log(String log, Object[] args, LogLevel current) {
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()) + " -- " +
                current.toString() + " " +
                clazz.getName() + " -- " +
                String.format(log.replace("{}", "%s"), args));
    }
}
