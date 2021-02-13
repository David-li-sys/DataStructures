package com.njsf;

import java.util.Arrays;
import java.util.Date;

public class F_A_BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {6,5,4,3,2,1};
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random()*800);
        }

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));


    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        //有话冒泡排序，如果有序则直接退出
        boolean flag = false;
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
//            System.out.println(Arrays.toString(arr));
            if(!flag){
                break;
            }else {
                flag = false;
            }

        }
    }
}
