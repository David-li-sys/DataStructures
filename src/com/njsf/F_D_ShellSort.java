package com.njsf;

import java.util.Arrays;

public class F_D_ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000000);
        }
        Long start = System.currentTimeMillis();
        shellSort(arr);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);


    }
    //交换法
    public static void shellSort(int[] arr){

        int temp = 0;
        for(int gap = arr.length/2; gap > 0; gap /= 2){
            for(int i = gap;i<arr.length; i++){
                for(int j = i-gap; j >= 0;j-=gap){
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }else{
                        break;
                    }

                }
            }
        }


    }
    //插入法
    public static void shellSort2(int[] arr){
        for(int gap = arr.length/2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]){
                    while(j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
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
