package com.n2gkosmas;
import java.util.Scanner;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args )
    {
        int i=0;
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Give size of array:");
        int size = myscanner.nextInt();
        double [] array_ex = new double[size];
        for(i=0;i<size;i++){
            System.out.println("\nGive a value of a double to set the "+i+" index of array:");
            array_ex[i] = myscanner.nextDouble();
        }

        StatisticUtilsArray obj = new StatisticUtilsArray(array_ex);
        System.out.println(obj.toString(obj.ds1));



}}
