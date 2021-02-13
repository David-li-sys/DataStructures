package com.njsf;

public class E_C_Queen8 {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        E_C_Queen8 queen8 = new E_C_Queen8();
        queen8.check(0);
        System.out.println("一共有解法："+count);
    }

    private void check(int n){
        if(n == max){
            print();
            return;
        }
        for(int i = 0;i < max; i++){
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n){
        for(int i = 0; i < n; i++){
            if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }

        }
        return true;
    }

    private void print(){
        count++;
        for(int i = 0; i< array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
