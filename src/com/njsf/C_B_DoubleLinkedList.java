package com.njsf;

/**
 *
 * 双向链表
 */
public class C_B_DoubleLinkedList {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");

        DoubleLinkedNodeHead doubleLinkedNodeHead = new DoubleLinkedNodeHead();
        doubleLinkedNodeHead.add(hero1);
        doubleLinkedNodeHead.add(hero2);
        doubleLinkedNodeHead.add(hero3);
        doubleLinkedNodeHead.add(hero4);

        doubleLinkedNodeHead.list();

        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedNodeHead.update(newHeroNode);
        System.out.println("-----------------修改后--------------------");
        doubleLinkedNodeHead.list();
        doubleLinkedNodeHead.del(3);
        System.out.println("-----------------删除后--------------------");
        doubleLinkedNodeHead.list();


    }
}

class DoubleLinkedNodeHead{
    private HeroNode2 head = new HeroNode2(0,"","");

    //遍历链表
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void update(HeroNode2 newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp=head;
        boolean flag = false;//是否找到指定节点
        while(true){
            if(temp == null){
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

    public void del(int no){
        if(head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//是否找到指定节点
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.pre.next = temp.next;
            if(temp.next != null){//如果要删除的节点是最后一个节点，不执行
                temp.next.pre = temp.pre;
            }

        }else{
            System.out.printf("要删除的节点%d不存在",no);
        }
    }
}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int hNo,String hName,String hNickname){
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
