package com.n2gkosmas;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
/**
 * For a given arrayList , it runs the code and it is persisted without any errors.
 *
 * @author Panos Kosmas
 * @version 1.0
 * @since 2019-13-11
 *
 */
public class StatisticUtilsArrayListTest {

    @Test
    public void statisticUtilsArrayListTest(){
        ArrayList<Double> testlist = new ArrayList<>();
        testlist.add(0.66);
        testlist.add(0.99);
        testlist.add(0.02);
        testlist.add(65.23);
        testlist.add(7.25);

        StatisticUtilsArrayList testobjet = new StatisticUtilsArrayList(testlist);
        assertFalse("ArrayList is too short." , testlist.size()<=0);
        assertNotNull("ArrayList is empty",testlist);
        assertEquals(0.02,testobjet.getMinimum(testobjet.ds1),0.0001); //delta is the precision in decimals.
        assertEquals(65.23,testobjet.getMaximum(testobjet.ds1),0.0001);
        assertEquals(0.99,testobjet.getMedian(testobjet.ds1),0.0001);
        assertEquals(14.83,testobjet.getMean(testobjet.ds1),0.0001);
        assertEquals(28.3252,testobjet.getStandardDeviation(testobjet.ds1),0.0001);
        System.out.println("0 errors!");
    }
}
