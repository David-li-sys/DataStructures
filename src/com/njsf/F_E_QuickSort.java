package com.njsf;

import java.util.Arrays;

public class F_E_QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000000);
        }
        Long start = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(right + left)/2];
        int temp;

        while(l < r){
            while(arr[l] < pivot){
                l++;
            }
            while(arr[r] > pivot){
                r--;
            }
            if(l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if(arr[l] == pivot){
                r--;
            }

            if(arr[r] == pivot){
                l++;
            }


        }
        if(l == r){
            l++;
            r--;
        }

        if(left < r){
            quickSort(arr,left,r);
        }
        if(right > l){
            quickSort(arr,l,right);
        }


    }
}
