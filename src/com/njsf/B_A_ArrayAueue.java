package com.njsf;

import java.util.Scanner;

public class B_A_ArrayAueue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");

            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n:",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队头的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
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

/**
 *
 * 定义队列
 */
class ArrayQueue{
    private int maxSize;//队列大小
    private int front;//队列头标
    private int rear;//队列尾标
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;
        rear = -1;
    }
    //队列是否为空
    public boolean isFull(){
        return rear == maxSize-1;
    }
    //队列是否已满
    public boolean isEmpty(){
        return rear == front;
    }
    //向队列添加数据
    public void addQueue(int n){
        if(isFull()){//判断队列是否慢
            System.out.println("队列满，不能添加数据");
            return;
        }

        rear++;
        arr[rear] = n;
    }
    //向队列取数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，没有数据可取");
        }
        front++;
        return arr[front];
    }

    //展示队列数据
     public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }

         for (int i = 0;i<arr.length;i++) {
             System.out.printf("arr[%d]=%d\n",i,arr[i]);
         }
     }
    //展示队列队头数据
     public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据");

        }
        return arr[front+1];
     }

}