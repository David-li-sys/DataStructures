package com.njsf;

public class I_G_BinarySortTreeDemo {
    public static void main(String[] args) {
        int arr[] = {7,3,10,12,5,1,9,2};

        BinarySortTree binarySortTree = new BinarySortTree();

        for (int i : arr) {
            BinarySortNode node = new BinarySortNode(i);
            binarySortTree.add(node);
        }

        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(12);
        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        binarySortTree.delNode(10);
        binarySortTree.delNode(1);

        binarySortTree.infixOrder();
    }
}

class BinarySortTree{
    private BinarySortNode root;

    public BinarySortNode getRoot(){
        return root;
    }

    public BinarySortNode search(int value){
        if(root == null){
            return null;
        }else{
            return root.search(value);
        }
    }

    public BinarySortNode searchParent(int value){
        if(root == null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }

    public int delRightTreeMin(BinarySortNode node){
        BinarySortNode target = node;
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
            BinarySortNode targetNode = search(value);
            if(targetNode == null){
                return;
            }
            if(root.left == null && root.right == null){
                root = null;
                return;
            }

            BinarySortNode parent = searchParent(value);

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

    public void add(BinarySortNode node){
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

class BinarySortNode{
    int value;
    BinarySortNode left;
    BinarySortNode right;

    public BinarySortNode(int value){
        this.value = value;
    }

    public BinarySortNode search(int value){
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

    public BinarySortNode searchParent(int value){
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

    public void add(BinarySortNode node){
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
        return "BinarySortNode{" +
                "value=" + value +
                '}';
    }
}
