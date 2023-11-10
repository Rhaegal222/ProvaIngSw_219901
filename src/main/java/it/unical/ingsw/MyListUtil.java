package it.unical.ingsw;

import java.util.Collections;
import java.util.List;

public class MyListUtil {
    public static List<Integer> sort(List<Integer> list, int order) {
        if (order == 0) {
            Collections.sort(list);
        } else if (order == 1) {
            Collections.sort(list, Collections.reverseOrder());
        }
        return list;
    }
}