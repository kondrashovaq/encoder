package org.ekondrashova.application.encoder.impl;

import org.ekondrashova.application.factory.LoggerFactory;
import org.ekondrashova.application.logger.Logger;

import java.util.Arrays;

public abstract class MatrixOperations {
    private final static Logger LOGGER = LoggerFactory.getLogger(MatrixOperations.class);

    public static String toSpiral(char[][] matrix) {
        LOGGER.trace("invoke toSpiral({})", Arrays.toString(matrix));
        StringBuilder stringBuilder = new StringBuilder();

        if (matrix == null || matrix.length == 0) {
            return stringBuilder.toString();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = 0;

        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    stringBuilder.append(matrix[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    stringBuilder.append(matrix[x++][y]);
                }
                break;
            }
            for (int i = 0; i < n - 1; i++) {
                stringBuilder.append(matrix[x][y++]);
            }
            for (int i = 0; i < m - 1; i++) {
                stringBuilder.append(matrix[x++][y]);
            }
            for (int i = 0; i < n - 1; i++) {
                stringBuilder.append(matrix[x][y--]);
            }
            for (int i = 0; i < m - 1; i++) {
                stringBuilder.append(matrix[x--][y]);
            }
            x++;
            y++;
            m -= 2;
            n -= 2;
        }
        String result = stringBuilder.toString();
        LOGGER.trace("result toSpiral({}) : {}", Arrays.toString(matrix), result);
        return result;
    }


    public static char[][] fromSpiral(String text, int order) {
        char[][] matrix = new char[order][order];
        int value = 0;
        int minCol = 0;
        int maxCol = order - 1;
        int minRow = 0;
        int maxRow = order - 1;
        while (value < text.length()) {
            for (int i = minCol; i <= maxCol; i++) {
                if (value == text.length()) {
                    break;
                }
                matrix[minRow][i] = text.charAt(value);
                value++;
            }

            for (int i = minRow + 1; i <= maxRow; i++) {
                if (value == text.length()) {
                    break;
                }
                matrix[i][maxCol] = text.charAt(value);
                value++;
            }

            for (int i = maxCol - 1; i >= minCol; i--) {
                if (value == text.length()) {
                    break;
                }
                matrix[maxRow][i] = text.charAt(value);
                value++;
            }

            for (int i = maxRow - 1; i >= minRow + 1; i--) {
                if (value == text.length()) {
                    break;
                }
                matrix[i][minCol] = text.charAt(value);
                value++;
            }
            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }
        LOGGER.trace("result fromSpiral({}, {}) : {}", text, order, Arrays.toString(matrix));
        return matrix;
    }
}
