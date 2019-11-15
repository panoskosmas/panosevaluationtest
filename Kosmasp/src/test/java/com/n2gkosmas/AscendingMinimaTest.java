package com.n2gkosmas;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
/**
 * Give an array as input
 * Give expected array for result
 * See if elements match one to another
 * Print the results on monitor
 *
 * @author Panos Kosmas
 * @version 1.0
 * @since 2019-13-11
 *
 */
public class AscendingMinimaTest {

    @Test
    public void ascendingMinimaTest(){

        AscendingMinima testobject = new AscendingMinima();

        //int [] array = {5,1,3,2,6,8,4,6};
        int [] array = {8,2,3,4,1,5,6,8,9};
        int k = 3; //window's size
        //int [] expected_result = {1,1,2,2,4,4};
        int [] expected_result = {2,2,1,1,1,5,6};
        int [] array_result = new int[expected_result.length];
        ArrayList<Integer> result = testobject.ascedingMinimaAlgorithm(array,k);
        for(int i=0;i<result.size();i++){
            array_result [i] = result.get(i);
            System.out.println(array_result[i]);
        }
        assertArrayEquals(expected_result,array_result);

    }
}
