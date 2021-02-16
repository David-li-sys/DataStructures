package com.njsf;

public class I_C_ThreadeBinaryTreeDemo {
    public static void main(String[] args) {
        HeroThreadBinaryNode hero1 = new HeroThreadBinaryNode(1, "tom");
        HeroThreadBinaryNode hero3 = new HeroThreadBinaryNode(3, "jack");
        HeroThreadBinaryNode hero6 = new HeroThreadBinaryNode(6, "smith");
        HeroThreadBinaryNode hero8 = new HeroThreadBinaryNode(8, "mary");
        HeroThreadBinaryNode hero10 = new HeroThreadBinaryNode(10, "king");
        HeroThreadBinaryNode hero14 = new HeroThreadBinaryNode(14, "dim");

        hero1.setLeft(hero3);
        hero1.setRight(hero6);
        hero3.setLeft(hero8);
        hero3.setRight(hero10);
        hero6.setLeft(hero14);

        ThreadBinaryTree tree = new ThreadBinaryTree();
        tree.setRoot(hero1);
        tree.threadedNodes();
        HeroThreadBinaryNode leftNode = hero10.getLeft();
        System.out.println(leftNode);



        System.out.println("--------------------------");
        tree.threadedList();



    }
}

class ThreadBinaryTree{
    private HeroThreadBinaryNode root;
    //指向当前节点的前驱指针
    private HeroThreadBinaryNode pre = null;

    public void setRoot(HeroThreadBinaryNode root){
        this.root = root;
    }

    public void threadedNodes(){
        threadedNodes(root);
    }

    public void threadedList(){
        HeroThreadBinaryNode node = root;
        while(node != null){
            while(node.getLeftType() == 0){
                node = node.getLeft();
            }
            System.out.println(node);

            while(node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    public void threadedNodes(HeroThreadBinaryNode node){
        if(node == null){
            return;
        }

        threadedNodes(node.getLeft());
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        threadedNodes(node.getRight());
    }

    public void delNode(int no){
        if(root != null){
            if(root.getNo() == no){
                root = null;
            }else{
                root.delNode(no);
            }

        }else{
            System.out.println("空树，不能删除");
        }
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

    public HeroThreadBinaryNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }

    public HeroThreadBinaryNode infixOrderSearch(int no){
        if(root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }

    public HeroThreadBinaryNode postOrderSearch(int no){
        if(root != null){
            return  root.posrOrderSearch(no);
        }else{
            return null;
        }
    }
}

class  HeroThreadBinaryNode{
    private int no;
    private String name;
    private HeroThreadBinaryNode left;
    private HeroThreadBinaryNode right;

    //等于0表示指向子树，等于1表示指向前驱后继
    private int leftType;
    private int rightType;

    public HeroThreadBinaryNode(int no, String name){
        this.no = no;
        this.name = name;
    }

    public void delNode(int no){
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }

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
    public HeroThreadBinaryNode preOrderSearch(int no){
        if(this.no == no){
            return this;
        }
        HeroThreadBinaryNode resNode = null;
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
    public HeroThreadBinaryNode infixOrderSearch(int no){
        HeroThreadBinaryNode resNode = null;
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
    public HeroThreadBinaryNode posrOrderSearch(int no){
        HeroThreadBinaryNode resNode = null;
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

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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

    public HeroThreadBinaryNode getLeft() {
        return left;
    }

    public void setLeft(HeroThreadBinaryNode left) {
        this.left = left;
    }

    public HeroThreadBinaryNode getRight() {
        return right;
    }

    public void setRight(HeroThreadBinaryNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroThreadBinaryNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
