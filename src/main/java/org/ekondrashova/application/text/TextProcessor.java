package org.ekondrashova.application.text;

import org.ekondrashova.application.encoder.Encoder;
import org.ekondrashova.application.factory.LoggerFactory;
import org.ekondrashova.application.logger.Logger;

public class TextProcessor {
    private final static Logger LOGGER = LoggerFactory.getLogger(TextProcessor.class);
    private final Encoder encoder;

    public TextProcessor(Encoder encoder) {
        this.encoder = encoder;
    }

    public String processAndEncodeText(String plain) {
        LOGGER.info("invoke processAndEncodeText({})", plain);
        String encoded = encoder.encode(plain);
        LOGGER.info("result processAndEncodeText({}) : {}", plain, encoded);
        return encoded;
    }

    public String processAndDecodeText(String encoded) {
        LOGGER.info("invoke processAndDecodeText({})", encoded);
        String decoded = encoder.decode(encoded);
        LOGGER.info("result processAndDecodeText({})", encoded, decoded);
        return decoded;
    }
}
