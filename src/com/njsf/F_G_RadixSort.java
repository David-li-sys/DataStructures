package com.njsf;

import java.util.Arrays;

public class F_G_RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[800000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int)(Math.random()*80000000);
        }
        Long start = System.currentTimeMillis();
        radixSort(arr);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void radixSort(int[] arr){
        int max= arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength =( max+"").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        for(int i =0 , n = 1; i < maxLength; i++,n*=10){
            for(int j = 0; j < arr.length; j++){
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;
            for(int k = 0; k < bucketElementCounts.length; k++){
                if(bucketElementCounts[k] != 0){
                    for(int l =0; l < bucketElementCounts[k]; l++){
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketElementCounts[k] = 0;
            }

        }

    }
}
