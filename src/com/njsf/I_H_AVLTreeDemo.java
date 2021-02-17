package com.njsf;

public class I_H_AVLTreeDemo {
    public static void main(String[] args) {
//        int arr[] = {4,3,6,5,7,8};
//        int arr[] = {10,12,8,9,7,6};
        int arr[] = {10,12,8,9,7,6};

        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++){
            avlTree.add(new AVLNode(arr[i]));
        }

        avlTree.infixOrder();
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot());

    }
}

class  AVLTree{
    private AVLNode root;

    public AVLNode getRoot(){
        return root;
    }

    public AVLNode search(int value){
        if(root == null){
            return null;
        }else{
            return root.search(value);
        }
    }

    public AVLNode searchParent(int value){
        if(root == null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }

    public int delRightTreeMin(AVLNode node){
        AVLNode target = node;
        while(target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value){
        if(root == null){
            return;
        }else{
            AVLNode targetNode = search(value);
            if(targetNode == null){
                return;
            }
            if(root.left == null && root.right == null){
                root = null;
                return;
            }

            AVLNode parent = searchParent(value);

            if(targetNode.left == null && targetNode.right == null){
                if(parent.left != null && parent.left.value == value){
                    parent.left = null;
                }else if(parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            }else if(targetNode.left != null && targetNode.right != null){
                int minValue = delRightTreeMin(targetNode.right);
                targetNode.value = minValue;

            }else{
                if(targetNode.left != null){
                    if(parent != null){
                        if(parent.left.value == value){
                            parent.left = targetNode.left;
                        }else{
                            parent.right = targetNode.left;
                        }
                    }else{
                        root = targetNode.left;
                    }

                }else{
                    if(parent != null){
                        if(parent.left.value == value){
                            parent.left = targetNode.right;
                        }else{
                            parent.right = targetNode.right;
                        }
                    }else{
                        root = targetNode.right;
                    }

                }
            }


        }
    }

    public void add(AVLNode node){
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }
    }

    public void infixOrder(){
        if(root != null){
            root.infixOreder();
        }else{
            System.out.println("二叉排序树为空，不能遍历");
        }
    }


}

class AVLNode{
    int value;
    AVLNode left;
    AVLNode right;

    public AVLNode(int value){
        this.value = value;
    }

    public int leftHeight(){
        if(left == null){
            return 0;
        }
        return left.height();
    }

    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();

    }
    public int height(){
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    private void leftRotate(){
        AVLNode newNode = new AVLNode(value);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.value = this.right.value;
        this.right = this.right.right;
        this.left = newNode;
    }

    private void rightRotate(){
        AVLNode newNode = new AVLNode(value);
        newNode.right = this.right;
        newNode.left =this.left.right;
        this.value = left.value;
        this.left = left.left;
        right = newNode;

    }

    public AVLNode search(int value){
        if(value == this.value){
            return this;
        }else if(value < this.value){
            if(this.left == null){
                return null;
            }
            return this.left.search(value);
        }else{
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }

    }

    public AVLNode searchParent(int value){
        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else{
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if(value >=  this.value && this.right != null){
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
    }

    public void add(AVLNode node){
        if(node == null){
            return;
        }
        if(node.value < this.value){
            if(this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }else{
            if(this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }

        if(rightHeight() - leftHeight() > 1){
            if(right != null && right.leftHeight() > right.rightHeight()){
                this.right.rightRotate();
                leftRotate();
            }else{
                leftRotate();
            }

            return;
        }
        if(leftHeight() - rightHeight() > 1){
            if(left != null && left.rightHeight() > left.leftHeight()){
                this.left.leftRotate();
                rightRotate();
            }else{
                rightRotate();;
            }

        }
    }

    public void infixOreder(){
        if(this.left != null){
            this.left.infixOreder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOreder();
        }
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "value=" + value +
                '}';
    }
}
