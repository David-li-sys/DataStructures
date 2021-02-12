package com.njsf;

/**
 * 约瑟夫问题
 */
public class C_C_Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);
       // circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,25);


    }
}

class CircleSingleLinkedList{
    private Boy boy = new Boy(-1);
    private Boy first = null;
    public void addBoy(int num){
        if(num < 1){
            System.out.println("num的值不正确");
            return;
        }
        Boy curBoy = null;
        for(int i =1;i <= num;i++){
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy(){
        if(first == null){
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy = first;
        while(true){
            System.out.println("小孩的编号："+curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    //startNo 表示开始节点
    //countNum 表示数几下
    //nums 表示一共几个节点
    public void countBoy(int startNo,int countNum,int nums){
        if(first == null || startNo <1 || startNo > nums){
            System.out.println("参数有误，请重新输入");
            return;
        }

        Boy helper = first;
        while(true){//让helper指向first的前一个节点
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        for(int j =0;j< startNo-1;j++){//移动到开始节点
            first = first.getNext();
            helper = helper.getNext();
        }

        while(true){//节点出圈
            if(helper == first){//只剩一个节点
                break;
            }

            for(int j =0;j < countNum -1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }

            System.out.printf("小孩%d出圈\n",first.getNo());//出圈小孩
            //去除出圈小孩
            first = first.getNext();
            helper.setNext(first);

        }

        System.out.printf("最后一个小孩%d出圈\n",first.getNo());
    }
}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
