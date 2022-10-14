package dev.kirwi.util;

import dev.kirwi.flist.FList;

public class FListUtil {

    public static <T> FList<T> intersectingNode(FList<T> a, FList<T> b) {
        if (a.isEmpty() || b.isEmpty()) {
            return null;
        } else if (a == b) {
            return a;
        } else {
            intersectingNode(a, b.tail());
            intersectingNode(a.tail(), b);
        }
        return null;
    }

    public static <T> FList<T> nodeRepeat(FList<T> a) {
        return intersectingNode(a, a.tail());
    }
}
