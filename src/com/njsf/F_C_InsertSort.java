package com.njsf;

import java.util.Arrays;

public class F_C_InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000000);
        }
        Long start = System.currentTimeMillis();
        insertSort(arr);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public static void insertSort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;
        for(int i = 1;i<arr.length;i++){
            insertVal = arr[i];//记录需要插入的数
            insertIndex = i-1;//前一个数索引
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                //不满足就后移
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            //插入

            arr[insertIndex+1] = insertVal;


        }

    }
}
