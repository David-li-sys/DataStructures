package com.njsf;

public class C_A_SingleLinkedList {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        HeadNode headNode = new HeadNode();
        headNode.add(hero1);
        headNode.add(hero2);
        headNode.add(hero3);
        headNode.add(hero4);

        headNode.list();
    }
}
//头结点
class HeadNode{
    private HeroNode head = new HeroNode(0,"","");

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