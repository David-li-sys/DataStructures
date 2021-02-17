package com.njsf;

import java.util.*;

public class I_F_HuffmanCode {
    static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();

        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
        System.out.println(Arrays.toString(huffmanCodeBytes));
        System.out.println(huffmanCodeBytes.length);
        byte[] sourceBytes = decode(huffmanCodes, huffmanCodeBytes);
        System.out.println(new String(sourceBytes));


    }
//----------------------------------解压-------------------------------------------//
    private static byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes){
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < huffmanBytes.length; i++){
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
        }

        Map<String,Byte> map = new HashMap<>();
        for(Map.Entry<Byte,String> entry : huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        List<Byte> list = new ArrayList<>();
        for(int i = 0; i < stringBuilder.length(); ){
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while(flag){
                String key = stringBuilder.substring(i,i + count);
                b = map.get(key);
                if(b == null){
                    count++;
                }else{
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] b = new byte[list.size()];
        for(int i =0; i < b.length; i++){
            b[i] = list.get(i);
        }
        return b;
    }

    private static String byteToBitString(boolean flag,byte b){
        int temp = b;
        if(flag){
            temp |= 256;
        }

        String str = Integer.toBinaryString(temp);

        if(flag){
            return str.substring(str.length() - 8);
        }else{
            return str;
        }

    }

//----------------------------------压缩-------------------------------------------//
    public static byte[] huffmanZip(byte[] bytes){
        List<CodeNode> nodes = getNodes(bytes);
        CodeNode root = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodes = getCodes(root);
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }

    public static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        //System.out.println(stringBuilder);
        int len;
        if(stringBuilder.length() % 8 == 0){
            len = stringBuilder.length() / 8;
        }else{
            len = stringBuilder.length() / 8 + 1;
        }

        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;

        for(int i = 0; i < stringBuilder.length(); i += 8){
            String strBytes;

            if(i + 8 > stringBuilder.length()){
                strBytes = stringBuilder.substring(i);
            }else{
                strBytes = stringBuilder.substring(i, i + 8);
            }


            huffmanCodeBytes[index] = (byte) Integer.parseInt(strBytes, 2);
            index++;
        }
        return huffmanCodeBytes;

    }


    private static Map<Byte,String> getCodes(CodeNode root){
        if(root == null){
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);

        return  huffmanCodes;
    }

    private static void getCodes(CodeNode node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if(node != null){
            if(node.data == null){
                getCodes(node.left, "0",stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            }else{
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    private static void preOrder(CodeNode root){
        if(root != null){
            root.preOrder();
        }else{
            System.out.println("huffman tree is empty,cannot order!!");
        }
    }

    public static List<CodeNode> getNodes(byte[] bytes){

        ArrayList<CodeNode> nodes = new ArrayList<>();

        Map<Byte,Integer> counts = new HashMap<>();

        for (byte b : bytes) {
            Integer count = counts.get(b);
            if(count == null){
                counts.put(b,1);
            }else{
                counts.put(b,count + 1);
            }
        }

        for(Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new CodeNode(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    private static CodeNode createHuffmanTree(List<CodeNode> nodes){
        while(nodes.size() > 1){
            Collections.sort(nodes);

            CodeNode leftNode = nodes.get(0);
            CodeNode rightNode = nodes.get(1);

            CodeNode parent = new CodeNode(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

class CodeNode implements Comparable<CodeNode>{
    Byte data;
    int weight;
    CodeNode left;
    CodeNode right;

    public CodeNode(Byte data, int weight){
        this.data = data;
        this.weight = weight;
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }


    @Override
    public int compareTo(CodeNode o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "CodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}
