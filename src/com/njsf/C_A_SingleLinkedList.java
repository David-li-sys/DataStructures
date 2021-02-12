package com.njsf;

import java.util.Stack;

public class C_A_SingleLinkedList {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        HeadNode headNode = new HeadNode();
//        headNode.add(hero1);
//        headNode.add(hero2);
//        headNode.add(hero3);
//        headNode.add(hero4);

        headNode.addByOrder(hero2);
        headNode.addByOrder(hero4);
        headNode.addByOrder(hero3);
        headNode.addByOrder(hero1);

        headNode.list();

        HeroNode newHeroNode = new HeroNode(2,"小卢","玉麒麟~~");
        headNode.update(newHeroNode);
        System.out.println("----------------------------------");
        headNode.list();

//        headNode.del(1);
//        System.out.println("----------------------------------");
//        headNode.list();
//        headNode.del(4);
//        System.out.println("----------------------------------");
//        headNode.list();
//        headNode.del(2);
//        System.out.println("----------------------------------");
//        headNode.list(); headNode.del(3);
//        System.out.println("----------------------------------");
//        headNode.list();

//        System.out.printf("链表长度：%d\n",getLength(headNode.getHead()));
//        HeroNode res = findLastIndexNode(headNode.getHead(),2);
//        System.out.println(res);
//        System.out.println("--------------反转后--------------------");
//        reverseList(headNode.getHead());
//        headNode.list();
        System.out.println("--------------逆序打印-----------------");
        reversePrint(headNode.getHead());

    }
    //逆序打印链表（使用栈）
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;

        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
    //将链表反转
    public static void reverseList(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;
        //临时头结点
        HeroNode reverseHead = new HeroNode(0,"","");
        //头插法
        while(cur != null){
            //记录当前节点的下一个节点
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        head.next = reverseHead.next;

    }
    //查找链表倒数指定元素
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if(head.next == null){
            return null;
        }
        int size = getLength(head);
        if(index <=0 && index > size){
            return null;
        }
        HeroNode cur = head.next;
        for(int i = 0;i<size-index;i++){
            cur = cur.next;
        }
        return cur;
    }
    //得到链表长度
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
}
//头结点
class HeadNode{
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead(){
        return head;
    }
    //直接添加
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    //排序添加
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no >heroNode.no ){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            System.out.printf("准备插入的英雄编号%d已经存在，不能加入\n",heroNode.no);
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    //遍历链表
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    //修改节点
    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head;
        boolean flag = false;//是否找到指定节点
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("没有找到编号为%d的节点，不能修改\n",newHeroNode.no);
        }
    }
    //删除节点
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;//是否找到指定节点
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的节点%d不存在",no);
        }
    }

}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int hNo,String hName,String hNickname){
        no = hNo;
        name = hName;
        nickname = hNickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}