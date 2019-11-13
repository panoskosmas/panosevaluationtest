package com.n2gkosmas;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * Provide a set of statistical values for an array of doubles (min,max,mean,median,stdDev).
 * DescriptiveStatistics commons maths3 library has any function Ι need for these calculations.
 *
 * @author Panos Kosmas
 * @version 1.0
 * @since 2019-13-11
 *
 */
class StatisticUtilsArray {

    DescriptiveStatistics ds1; //create a descriptiveStatistics object
    /**
     * This is the constructor , checks if input is null/short and if not
     * it creates a DescriptiveStatistics object which is useful for the calculations.
     */
    StatisticUtilsArray(double[] array){
        if((array==null)||(array.length<=0)){
            System.out.println("Array too short or empty. Try again!");        }
        else { ds1 = new DescriptiveStatistics(array); }
    }
    double getMinimum(DescriptiveStatistics ds1){
        return ds1.getMin();
    }
    double getMaximum(DescriptiveStatistics ds1){
        return ds1.getMax();
    }
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

    /**
     * toString() method
     * @param ds1
     * @return the values printed on the standard output
     */
    String toString(DescriptiveStatistics ds1){
        return ("Min: "+ds1.getMin()+"\nMax: "+ds1.getMax()+"\nMean: "+ds1.getMean()+"\nMedian: "+ds1.getPercentile(50.0)+"\nStdDev: "+
            ds1.getStandardDeviation());
    }

}
