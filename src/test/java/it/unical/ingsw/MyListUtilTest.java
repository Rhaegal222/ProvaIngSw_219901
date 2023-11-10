package it.unical.ingsw;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyListUtilTest {

    @Test
    public void testSortEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> sortedList = MyListUtil.sort(emptyList, 1);
        assertEquals(emptyList, sortedList);
    }

    @Test
    public void testSortNullList() {
        List<Integer> nullList = null;
        List<Integer> sortedList = MyListUtil.sort(nullList, 1);
        assertNull(sortedList);
    }

    @Test
    public void testSortAscendingWithDuplicates() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5));
        List<Integer> sortedList = MyListUtil.sort(list, 0);
        assertEquals(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9), sortedList);
    }

    @Test
    public void testSortDescendingWithDuplicates() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5));
        List<Integer> sortedList = MyListUtil.sort(list, 1);
        assertEquals(Arrays.asList(9, 6, 5, 5, 5, 4, 3, 3, 2, 1, 1), sortedList);
    }

    @Test
    public void testSortAscendingWithNegativeNumbers() {
        List<Integer> list = new ArrayList<>(Arrays.asList(-3, 1, -4, 1, 5, 9, -2, 6, 5, -3, 5));
        List<Integer> sortedList = MyListUtil.sort(list, 0);
        assertEquals(Arrays.asList(-4, -3, -3, -2, 1, 1, 5, 5, 5, 6, 9), sortedList);
    }

    @Test
    public void testSortDescendingWithNegativeNumbers() {
        List<Integer> list = new ArrayList<>(Arrays.asList(-3, 1, -4, 1, 5, 9, -2, 6, 5, -3, 5));
        List<Integer> sortedList = MyListUtil.sort(list, 1);
        assertEquals(Arrays.asList(9, 6, 5, 5, 5, 1, 1, -2, -3, -3, -4), sortedList);
    }
    
    @Before
    public void printStart() {
        DateTime start = new DateTime();
        System.out.println("Start time: " + start.toString("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    @After
    public void printEnd() {
        DateTime end = new DateTime();
        System.out.println("End time: " + end.toString("yyyy-MM-dd HH:mm:ss.SSS"));
    }
}