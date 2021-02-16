package com.njsf;

import java.util.Arrays;

public class I_D_HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000000);
        }
        Long start = System.currentTimeMillis();
        heapSort(arr);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void heapSort(int[] arr){
        int temp = 0;

        for(int i = arr.length / 2 - 1; i >= 0; i--){
            adjustHeap(arr, i ,arr.length);
        }
        for(int j = arr.length - 1; j > 0; j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];
        for(int k = i * 2 + 1; k < length; k = k * 2 +1){
            if(k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }

        arr[i] = temp;
    }
}
