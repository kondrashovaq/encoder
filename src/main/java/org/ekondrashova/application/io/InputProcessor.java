package org.ekondrashova.application.io;

import org.ekondrashova.application.factory.LoggerFactory;
import org.ekondrashova.application.logger.Logger;
import org.ekondrashova.application.text.TextProcessor;

public class InputProcessor {
    private final static Logger LOGGER = LoggerFactory.getLogger(InputProcessor.class);
    private final TextProcessor textProcessor;

    public InputProcessor(TextProcessor textProcessor) {
        this.textProcessor = textProcessor;
    }

    public String processIO(Operation operation, String text) {
        LOGGER.info("invoke processIO({}, {})", operation, text);

        switch (operation) {
            case ENCODE:
                String encoded = textProcessor.processAndEncodeText(text);
                LOGGER.info("result processIO({}) : {}", operation, encoded);
                return encoded;
            case DECODE:
                String decoded = textProcessor.processAndDecodeText(text);
                LOGGER.info("result processIO({}) : {}", operation, decoded);
                return decoded;
            default:
                return "";
        }
    }
}
