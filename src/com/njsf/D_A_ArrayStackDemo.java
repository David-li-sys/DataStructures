package com.njsf;

import java.util.Scanner;

public class D_A_ArrayStackDemo {
    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:添加数据到栈");
            System.out.println("pop:将数据从栈取出");
            System.out.println("请输入你的选择：");
            key = scanner.next();

            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("出栈的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }

        }
        System.out.println("程序退出");
    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //栈是否满
    public boolean isFull(){
        return top == maxSize -1;
    }
    //栈是否空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈空没有数据");
            return;
        }
        for(int i = top;i >= 0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
