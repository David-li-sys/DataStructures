package com.njsf;

public class I_A_BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroBinaryNode hero1 = new HeroBinaryNode(1,"宋江");
        HeroBinaryNode hero2 = new HeroBinaryNode(2,"吴用");
        HeroBinaryNode hero3 = new HeroBinaryNode(3,"卢俊义");
        HeroBinaryNode hero4 = new HeroBinaryNode(4,"林冲");
        HeroBinaryNode hero5 = new HeroBinaryNode(5,"关胜");

        hero1.setLeft(hero2);
        hero1.setRight(hero3);
        hero3.setRight(hero4);
        hero3.setLeft(hero5);
        binaryTree.setRoot(hero1);
//        System.out.println("--------前序遍历-------");
//        binaryTree.preOrder();
//        System.out.println("--------中序遍历-------");
//        binaryTree.infixOrder();
//        System.out.println("--------后序遍历-------");
//        binaryTree.postOrder();

        //HeroBinaryNode resNode = binaryTree.preOrderSearch(3);
        HeroBinaryNode resNode = binaryTree.infixOrderSearch(13);
        System.out.println(resNode);
    }
}

class BinaryTree{
    private HeroBinaryNode root;

    public void setRoot(HeroBinaryNode root){
        this.root = root;
    }

    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历");
        }
    }
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    public HeroBinaryNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }

    public HeroBinaryNode infixOrderSearch(int no){
        if(root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }

    public HeroBinaryNode postOrderSearch(int no){
        if(root != null){
            return  root.posrOrderSearch(no);
        }else{
            return null;
        }
    }
}

class HeroBinaryNode{
    private int no;
    private String name;
    private HeroBinaryNode left;
    private HeroBinaryNode right;

    public HeroBinaryNode(int no, String name){
        this.no = no;
        this.name = name;
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);

        if(this.right != null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //前序查找
    public HeroBinaryNode preOrderSearch(int no){
        if(this.no == no){
            return this;
        }
        HeroBinaryNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;

    }
    //中序查找
    public HeroBinaryNode infixOrderSearch(int no){
        HeroBinaryNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }

        if(this.no == no){
            return this;
        }
        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }

        return  resNode;
    }
    //后续查找
    public HeroBinaryNode posrOrderSearch(int no){
        HeroBinaryNode resNode = null;
        if(this.left != null){
            resNode = this.left.posrOrderSearch(no);

        }
        if(resNode != null){
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.posrOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.no == no){
            return this;
        }
        return resNode;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroBinaryNode getLeft() {
        return left;
    }

    public void setLeft(HeroBinaryNode left) {
        this.left = left;
    }

    public HeroBinaryNode getRight() {
        return right;
    }

    public void setRight(HeroBinaryNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroBinaryNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
