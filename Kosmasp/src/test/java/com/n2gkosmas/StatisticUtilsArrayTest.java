package com.n2gkosmas;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * For a given array , it runs the code and it is persisted without any errors.
 *
 * @author Panos Kosmas
 * @version 1.0
 * @since 2019-13-11
 *
 */
public class StatisticUtilsArrayTest {

    @Test
    public void statsUtilsArrayTest(){
        double [] array = {0.66 , 0.99 , 0.02 , 65.23 , 7.25};
    //   double [] array = null;
    //   double [] array ={};
        StatisticUtilsArray testobjet = new StatisticUtilsArray(array);
        assertFalse("Array is too short." , array.length<=0);
        assertNotNull("Array is empty",array);
        assertEquals(0.02,testobjet.getMinimum(testobjet.ds1),0.0001); //delta is the precision in decimals.
        assertEquals(65.23,testobjet.getMaximum(testobjet.ds1),0.0001);
        assertEquals(0.99,testobjet.getMedian(testobjet.ds1),0.0001);
        assertEquals(14.83,testobjet.getMean(testobjet.ds1),0.0001);
        assertEquals(28.3252,testobjet.getStandardDeviation(testobjet.ds1),0.0001);
        System.out.println("0 errors!");

    }
}
