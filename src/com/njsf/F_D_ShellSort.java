package com.njsf;

import java.util.Arrays;

public class F_D_ShellSort {
    public static void main(String[] args) {
        int[] arr = {3,6,2,9,1};
        System.out.println(Arrays.toString(arr));
        System.out.println("====================================");
        test(arr);


    }

    public static void shellSort(int[] arr){

        int temp = 0;
        for(int gap = arr.length/2; gap > 0; gap /= 2){
            for(int i = gap;i<arr.length; i++){
                for(int j = i-gap; j >= 0;j-=gap){
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }

                }
            }
        }


    }
    public static void test(int[] arr){
        int temp;
        for(int i = 1;i<arr.length; i++){
            for(int j = i-1; j >= 0;j-=1){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("------------------------");
        }
    }

}
