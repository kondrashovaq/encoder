package org.ekondrashova.application.utils;

public abstract class MathUtils {
    public static int getNextPerfectSquare(int number) {
        int n = (int) Math.floor(Math.sqrt(number)) + 1;
        return n * n;
    }

    public static boolean isPerfectSquare(int number) {
        double sq = Math.sqrt(number);
        return ((sq - Math.floor(sq)) == 0);
    }
}
