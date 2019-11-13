package com.n2gkosmas;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * For a given array of doubles , it runs the code , converts it to Stream
 * and returns the desired values without any errors.
 *
 * @author Panos Kosmas
 * @version 1.0
 * @since 2019-13-11
 *
 */
public class StatisticUtilsArrayStreamTest {

    @Test
    public void statisticUtilsArrayTestStream(){
        double [] array = {0.66 , 0.99 , 0.02 , 65.23 , 7.25};
        //   double [] array = null;
        //   double [] array ={};
        StatisticUtilsArrayStream teststream = new StatisticUtilsArrayStream(array);
        assertNotNull("Array is empty.", array);
        assertFalse("Array is too short." , array.length<=0);
        assertEquals(0.02,teststream.getMinimum(array),0.0001);//delta is the precision in decimals.
        assertEquals(65.23,teststream.getMaximum(array),0.0001);
        assertEquals(0.99,teststream.getMedian(array),0.0001);
        assertEquals(14.83,teststream.getMean(array),0.0001);
        assertEquals(25.3349,teststream.getStandardDeviation(array),0.0001);
        System.out.println("0 errors!");

    }
}
