package org.ekondrashova.application.utils;

import java.util.Collection;

public abstract class CollectionUtils {
    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }
}
