package org.ekondrashova.application.encoder.impl;

import org.ekondrashova.application.encoder.Encoder;
import org.ekondrashova.application.logger.Logger;
import org.ekondrashova.application.factory.LoggerFactory;
import org.ekondrashova.application.utils.MathUtils;
import org.ekondrashova.application.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

public class MatrixEncoder implements Encoder {
    private final static Logger LOGGER = LoggerFactory.getLogger(MatrixEncoder.class);

    @Override
    public String encode(String plain) {
        LOGGER.debug("invoke encode({})", plain);
        char[][] encodedMatrix = stringToMatrix(plain);
        String encodedString = MatrixOperations.toSpiral(encodedMatrix);
        LOGGER.debug("result encode({}) : {}", plain, encodedString);
        return encodedString;
    }

    @Override
    public String decode(String encoded) {
        LOGGER.debug("invoke decode({})", encoded);
        int order = calculateOrder(encoded.length());
        char[][] decodedMatrix = MatrixOperations.fromSpiral(encoded, order);
        String decodedString = matrixToString(decodedMatrix);
        LOGGER.debug("result decode({}) : {}", encoded, decodedString);
        return decodedString;
    }

    private char[][] stringToMatrix(String plain) {
        LOGGER.trace("invoke stringToMatrix({})", plain);
        int order = calculateOrder(plain.length());

        List<String> parts = StringUtils.partition(plain, order);

        StringUtils.fillLastWithSpaces(parts, order);

        char[][] matrix = new char[order][order];
        for (int i = 0; i < order; i++) {
            char[] symbols = parts.get(i).toCharArray();
            matrix[i] = symbols;
        }
        LOGGER.trace("result stringToMatrix({}) : {}", plain, Arrays.toString(matrix));
        return matrix;
    }

    private String matrixToString(char[][] matrix) {
        LOGGER.trace("invoke matrixToString({})", Arrays.toString(matrix));
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] row : matrix) {
            stringBuilder.append(String.valueOf(row));
        }
        String result = stringBuilder.toString().trim();
        LOGGER.trace("result matrixToString({}) : {}", Arrays.toString(matrix), result);
        return result;
    }

    private int calculateOrder(int length) {
        LOGGER.trace("invoke calculateOrder({})", length);
        if (MathUtils.isPerfectSquare(length)) {
            return (int) Math.sqrt(length);
        }
        int perfectSquare = MathUtils.getNextPerfectSquare(length);
        int order = (int) Math.sqrt(perfectSquare);
        LOGGER.trace("invoke calculateOrder({}) : {}", length, order);
        return order;
    }
}
