package org.ekondrashova.application.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class StringUtils {
    public static List<String> partition(String text, int size) {
        List<String> result = new ArrayList<>((text.length() + size - 1) / size);
        for (int start = 0; start < text.length(); start += size) {
            result.add(text.substring(start, Math.min(text.length(), start + size)));
        }
        return result;
    }

    public static void fillLastWithSpaces(List<String> strings, int order) {
        if (CollectionUtils.isEmpty(strings)) {
            return;
        }
        int length = strings.size() - 1;
        String temp = strings.get(length);
        strings.set(length, temp + " ".repeat(order - temp.length()));
        if (strings.size() != order) {
            strings.add(" ".repeat(order));
        }
    }
}
