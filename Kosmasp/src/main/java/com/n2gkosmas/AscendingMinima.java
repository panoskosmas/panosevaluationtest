package com.n2gkosmas;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * This project consists of 3 Steps (3 methods)
 * 1) findAscendingMinima-returns AMA for a given window by using recursion.
 * 2) adjustAscendingMinima-reconstructs AMA when the window slides and a new element is added to it.
 * 3) ascendingMinimaAlgorithm-by using both (1) and (2) it returns the final result array for a given array and window.
 *
 * All methods' return type is preferred to be ArrayList , because its fast&easy
 * plus we need to return a list of array containing some data.
 *
 * @author Panos Kosmas
 * @version 1.0
 * @since 2019-13-11
 *
 */
 class AscendingMinima {
    //STEP1: find AscendingMinimaArray for a given window:
    private ArrayList<Integer> findAscedingMinima(int[] window, ArrayList<Integer> ama) {
        if (window.length == 0) {
            return ama; //if window has no elements , return AmA .
        }
        else if (window.length == 1) {
            ama.add(window[0]); //if window has 1 element , add it to AmA and return.
            return ama;
        }
        else {
            int index=0;
            int min = window[0];

                for (int i = 0; i < window.length; i++) { //else find the minimum element in window
                    if (window[i] <= min) {
                        min = window[i];
                        index = i;
                    }
                }
                ama.add(window[index]); //add it to AmA
            return ama;
        }
    }

    //STEP2: Adjusting asceding minima for window shift
    //@element is the value of the new element inserted to window.
    private ArrayList<Integer> adjustAmaForWindowShift(int element, int[] window, ArrayList<Integer> ama) {

        if (window[0] == ama.get(0)) {
            ama.remove(0); //Check if the element to be discarded , belongs to Ama and if true discard it too.
        }
        int p = ama.size();
        while ( (p >= 1) && (ama.get(p - 1) > element) ) {
            ama.remove(ama.size() - 1);//then find which elements in existing AmA are greater than the new element
            p--;                             //inserted and remove them .
        }
        ama.add(element);                   //finally add the new element.
        return ama;
    }

    /**Run The Ascending Minima Algorithm for a given array.
    *@param array  is the given array of size n (may be a Stream also).
    *@param length  is window's current size.
    */
    ArrayList<Integer> ascedingMinimaAlgorithm(int[] array, int length) {
        ArrayList<Integer> ama = new ArrayList<>(); //create an AmA arraylist , so that when an element is discarded ,
                                                    // the rest of them have {index'=index-1} by default.
        ArrayList<Integer> result = new ArrayList<>(); //this contains the desired output values .
        int [] window = Arrays.copyOfRange(array,0,length);//Define the initial contents of the window.
        ama = findAscedingMinima(window , ama); //find Ama for the given window
        result.add(ama.get(0));    //add the 1st element of Ama(which is the minimum among all) to the result-arraylist.
        for(int i=length;i<array.length;i++){
            int element = array[i];             //array[i] = the next element to be added to the window.
            ama = adjustAmaForWindowShift(element,window,ama);
            window = Arrays.copyOfRange(array,i-length+1,i+1); //the window slides by one position every time.
            result.add(ama.get(0));
        }
        return result;
    }
}
