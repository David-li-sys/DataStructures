package com.njsf;

import java.util.Arrays;

public class F_F_MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[8];
        int[] temp = new int[arr.length];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random()*80000000);
        }
        Long start = System.currentTimeMillis();
        mergeSort(arr,0,arr.length-1,temp);
        Long end = System.currentTimeMillis();
        //System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;

        while(i <= mid && j <= right){
            if(arr[i] <= arr[j] ){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while(i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }

        while(j <= mid){
            temp[t] = arr[j];
            t++;
            j++;
        }

        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){

            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
