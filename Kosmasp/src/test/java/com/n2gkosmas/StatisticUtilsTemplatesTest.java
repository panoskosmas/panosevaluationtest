package com.n2gkosmas;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.lang.Number;
import static org.junit.Assert.*;

/**
 * It uses the Generic Numerical Type T which extends Numbers
 * so that it can accept every data type as an input
 * and returns the wanted values as doubles.
 * @param <T>
 *
 * @author Panos Kosmas
 * @version 1.0
 * @since 2019-13-11
 */
public class StatisticUtilsTemplatesTest <T extends Number>  {

    @Test
    public void statisticUtilsTemplatesTest (){
        List <Double> testlist = new ArrayList<>() ;
        testlist.add(0.66);
        testlist.add(0.99);
        testlist.add(0.02);
        testlist.add(65.23);
        testlist.add(7.25);
    /*  List <Integer> testlist2 = new ArrayList<>();
        testlist2.add(1);
        testlist2.add(2);
        testlist2.add(3);
        testlist2.add(65);
        testlist2.add(7);*/

        StatisticUtilsTemplates<T> testobjet = new StatisticUtilsTemplates<T>((List<T>) testlist);
        assertFalse("ArrayList is too short." , testlist.size()<=0);
        assertEquals(0.02,testobjet.getMinimum(testobjet.ds1),0.0001);
        assertEquals(65.23,testobjet.getMaximum(testobjet.ds1),0.0001);
        assertEquals(0.99,testobjet.getMedian(testobjet.ds1),0.0001);//delta indicates the precision.
        assertEquals(14.83,testobjet.getMean(testobjet.ds1),0.0001);
        assertEquals(28.3252,testobjet.getStandardDeviation(testobjet.ds1),0.0001);
        System.out.println("0 errors!");
    }
}
