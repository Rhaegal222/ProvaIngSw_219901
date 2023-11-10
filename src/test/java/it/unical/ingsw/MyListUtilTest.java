package it.unical.ingsw;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyListUtilTest {
    private List<Integer> list;

    @Before
    public void setUp() {
        list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5));
    }

    @Test
    public void testSortAscending() {
        List<Integer> sortedList = MyListUtil.sort(list, 1);
        assertEquals(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9), sortedList);
    }

    @Test
    public void testSortDescending() {
        List<Integer> sortedList = MyListUtil.sort(list, -1);
        assertEquals(Arrays.asList(9, 6, 5, 5, 5, 4, 3, 3, 2, 1, 1), sortedList);
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