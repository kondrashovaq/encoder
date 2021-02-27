package org.ekondrashova.application.factory;

import org.ekondrashova.application.encoder.impl.MatrixEncoder;
import org.ekondrashova.application.io.InputProcessor;
import org.ekondrashova.application.text.TextProcessor;

public abstract class InputProcessorFactory {
    public static InputProcessor getInputProcessorWithMatrixEncoder() {
        return new InputProcessor(new TextProcessor(new MatrixEncoder()));
    }
}
