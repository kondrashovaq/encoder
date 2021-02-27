package org.ekondrashova.application.encoder;

public interface Encoder {
    String encode(String decoded);

    String decode(String encoded);
}
