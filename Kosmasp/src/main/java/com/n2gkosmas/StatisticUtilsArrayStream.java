package com.n2gkosmas;


import java.util.Arrays;
import java.util.stream.DoubleStream;
/**
 * Provide a set of statistical values for an array of doubles (min,max,mean,median,stdDev).
 * Firstly it converts an array to stream (DoubleStream in our case) and then it returns
 * the values as doubles , using the necessary methods, provided by .stream.DoubleStream library.
 *
 * @author Panos Kosmas
 * @version 1.0
 * @since 2019-13-11
 *
 */
 class StatisticUtilsArrayStream {

    double [] array1 ;

      StatisticUtilsArrayStream(double[] array) {
        if ((array == null) || (array.length <= 0)) {
            System.out.println("Array too short or empty. Try again!");
        }
        else {
            array1 = array;
        }
    }
     double getMinimum( double [] arr){
        DoubleStream stream1 = Arrays.stream(arr);
        return stream1.min().getAsDouble();
    }
     double getMaximum(double [] arr ){
        DoubleStream stream1 = Arrays.stream(arr);
        return  stream1.max().getAsDouble();
    }

    /**
     *getMedian method firstly SORTS the stream's elements
     *then through SKIP method , it returns the stream consisting of the remaining elements of the initial one,
     *after discarding the first ((arlength+1)/2)-1 elements.
     *Then by using LIMIT method , it truncates the stream to be no longer than (1+(1+arlength)%2) size.
     * So if initially the size was even , it now consists of the two median values , and if size was odd it only keeps
     * the median value.
     * then it implements the average() method , so that the result is taken and returns it as a double.
     */
     double getMedian( double [] arr){
        DoubleStream stream1 = Arrays.stream(arr);
        return stream1.sorted().skip(Math.max(0,((arr.length+1)/2)-1)).limit(1+(1+arr.length)%2).average().getAsDouble();
    }
     double getMean( double [] arr){
        DoubleStream stream1 = Arrays.stream(arr);
        return stream1.average().getAsDouble();
    }

    /**
     *We know that standard deviation is the square root of variance
     *DoubleStream lib provides us the way to find variance
     * and then we return StdDev by using Math.sqrt(var) method.
     */
     double getStandardDeviation(double [] arr ){
        //Here i created 2 streams for the same use , due to "Stream has already been operated upon or closed" error.
        DoubleStream stream1 = Arrays.stream(arr);
        DoubleStream stream2 = Arrays.stream(arr);
        double mean = stream1.average().getAsDouble();
        double variance = stream2.map(i -> i-mean)
                .map(i -> i*i)
                .average().getAsDouble();
        return Math.sqrt(variance);
    }
        }

