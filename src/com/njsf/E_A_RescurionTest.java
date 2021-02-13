package com.njsf;

public class E_A_RescurionTest {
    public static void main(String[] args) {
        int res = factorial(5);
        System.out.println(res);
    }
    public static void test(int n){
        if(n > 2){
            test(n-1);
        }
        System.out.println("n = "+n);
    }

    public static int factorial(int n){
        if(n == 1){
            return n;
        }
            return  n * factorial(n-1);

    }
}
