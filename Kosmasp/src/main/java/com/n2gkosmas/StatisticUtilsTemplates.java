package com.n2gkosmas;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.List;
import java.lang.Number;
/**
 * Provide a set of statistical values for any data type given in List format (min,max,mean,median,stdDev) by
 * using NumberTemplate.
 * DescriptiveStatistics commons maths3 library has any function Ι need for these calculations.
 * NumbersClass is useful, bcs all possible NumericalTypes are included (int,double,short,long,byte,float).
 * @author Panos Kosmas
 * @version 1.0
 * @since 2019-13-11
 *
 */
 class StatisticUtilsTemplates <T extends Number> {

    DescriptiveStatistics ds1;

     StatisticUtilsTemplates (List <T> mylist) {
        if ((mylist == null) || (mylist.size() <= 0)) {
            System.out.println("List too short or empty. Try again!");
        } else {
            ds1 = new DescriptiveStatistics();
            for (int i = 0; i < mylist.size(); i++) {     //IntelliJ platform suggested --> for (Double aDouble: mylist)
                ds1.addValue(mylist.get(i).doubleValue());//use doubleValue() method,bcs addValue gets only double args.
            }
        }
    }
     double getMinimum(DescriptiveStatistics ds1){
        return ds1.getMin();
    }
     double getMaximum(DescriptiveStatistics ds1){
        return ds1.getMax();
    }//It has to return the median value, if array's size is even , median is the average of both .
    //The median is the 50th percentile: the point in the data where 50% of the data fall below that point, and 50% fall above it.
     double getMedian(DescriptiveStatistics ds1){
        return ds1.getPercentile(50.0);
    }
     double getMean(DescriptiveStatistics ds1){ return ds1.getMean(); }
     double getStandardDeviation(DescriptiveStatistics ds1){
        return ds1.getStandardDeviation();
    }
     String toString(DescriptiveStatistics ds1){
        return ("Min: "+ds1.getMin()+"\nMax: "+ds1.getMax()+"\nMean: "+ds1.getMean()+"\nMedian: "+ds1.getPercentile(50.0)+"\nStdDev: "+
                ds1.getStandardDeviation());
    }

}

