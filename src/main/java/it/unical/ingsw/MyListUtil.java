package it.unical.ingsw;

import java.util.Collections;
import java.util.List;

public class MyListUtil {

    public static List<Integer> sort(List<Integer> list, int order) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        quicksort(list, 0, list.size() - 1);
        if (order > 0) {
            Collections.reverse(list);
        }
        return list;
    }

    private static void quicksort(List<Integer> list, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(list, left, right);
            quicksort(list, left, pivotIndex - 1);
            quicksort(list, pivotIndex + 1, right);
        }
    }

    private static int partition(List<Integer> list, int left, int right) {
        int pivot = list.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (list.get(j) <= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, right);
        return i + 1;
    }
}