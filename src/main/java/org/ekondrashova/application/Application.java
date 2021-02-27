package org.ekondrashova.application;

import org.ekondrashova.application.factory.InputProcessorFactory;
import org.ekondrashova.application.factory.LoggerFactory;
import org.ekondrashova.application.io.InputProcessor;
import org.ekondrashova.application.io.Operation;
import org.ekondrashova.application.logger.LogLevel;
import org.ekondrashova.application.logger.Logger;

public class Application {
    private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Logger.setLogLevel(LogLevel.TRACE);
        InputProcessor inputProcessor = InputProcessorFactory.getInputProcessorWithMatrixEncoder();
        String encoded = inputProcessor.processIO(Operation.ENCODE);
        LOGGER.info("RESULT OF ENCODING: {}", encoded);
        String decoded = inputProcessor.processIO(Operation.DECODE);
        LOGGER.info("RESULT OF DECODING: {}", decoded);
    }
}
