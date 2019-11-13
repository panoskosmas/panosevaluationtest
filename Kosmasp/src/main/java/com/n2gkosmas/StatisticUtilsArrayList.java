package com.n2gkosmas;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.ArrayList;
/**
 * Provide a set of statistical values for an arrayList of doubles (min,max,mean,median,stdDev).
 * DescriptiveStatistics commons maths3 library has any function Ι need for these calculations.
 *
 * @author Panos Kosmas
 * @version 1.0
 * @since 2019-13-11
 *
 */
class StatisticUtilsArrayList {

    DescriptiveStatistics ds1;

    /**
     * This is the constructor , checks if input is null/short and if not
     * it creates a DescriptiveStatistics object which is useful for the calculations
     * by adding all list's element to the dataset.
     */
    StatisticUtilsArrayList(ArrayList<Double> mylist) {
        if ((mylist == null) || (mylist.size() <= 0)) {
            System.out.println("ArrayList too short or empty. Try again!");
        }
        else {
             ds1 = new DescriptiveStatistics();

             for (int i = 0; i < mylist.size(); i++) {  //IntelliJ platform suggested --> for (Double aDouble: mylist)
                ds1.addValue(mylist.get(i));            //Adds the value(mylist's elements) to the dataset.
             }
        }
    }
    double getMinimum(DescriptiveStatistics ds1){
     return ds1.getMin();
 }
    double getMaximum(DescriptiveStatistics ds1){ return ds1.getMax(); }
    /**
     *To find the median value: If array's size is even , median is the average of the two in the middle.
     *The median is the 50th percentile: the point in the data where 50% of the data fall below that point,
     *and 50% fall above it.
     */
    double getMedian(DescriptiveStatistics ds1){
     return ds1.getPercentile(50.0);
 }
    double getMean(DescriptiveStatistics ds1){
     return ds1.getMean();
 }
    double getStandardDeviation(DescriptiveStatistics ds1){
     return ds1.getStandardDeviation();
 }
    String toString(DescriptiveStatistics ds1){
        return ("Min: "+ds1.getMin()+"\nMax: "+ds1.getMax()+"\nMean: "+ds1.getMean()+"\nMedian: "+ds1.getPercentile(50.0)+"\nStdDev: "+
                ds1.getStandardDeviation());
 }

}
