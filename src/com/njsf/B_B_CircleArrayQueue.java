package com.njsf;

import java.util.Scanner;

public class B_B_CircleArrayQueue {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
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
class CircleArrayQueue{
    private int maxSize;//队列大小
    private int front;//队列头标，等于队首下标
    private int rear;//队列尾标，等于队尾下标加一
    private int[] arr;

    public CircleArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull(){
        return (rear + 1)% maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满，不能添加数据");
            return;
        }

        arr[rear] = n;
        rear = (rear+1) % maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，没有数据可取");
        }
        int value = arr[front];
        front = (front +1) % maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }

        for(int i = front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }
    //计算数据个数
    public int size(){
        return (rear+maxSize-front) % maxSize;
    }


    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }

}