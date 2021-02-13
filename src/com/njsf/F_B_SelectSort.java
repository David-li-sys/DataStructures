package com.njsf;

import java.util.Arrays;

public class F_B_SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000000);
        }
        Long start = System.currentTimeMillis();
        selectSort(arr);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public static void selectSort(int[] arr){

        for(int i = 0;i < arr.length -1 ; i++){
            int minIdex = i;
            int min = arr[i];
            for(int j = 1+i; j < arr.length; j++){
                if(min > arr[j]){
                    minIdex = j;
                    min = arr[j];
                }
            }
            if(minIdex != i){
                arr[minIdex] = arr[i];
                arr[i] = min;
            }


        }

    }
}
