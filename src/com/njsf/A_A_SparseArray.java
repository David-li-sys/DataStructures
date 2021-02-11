package com.njsf;

import java.io.*;

/**
 *
 * 稀疏数组
 */

public class A_A_SparseArray {
    public static void main(String[] args) throws IOException {
        //创建棋盘，并初始化值
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[3][4] = 2;

        System.out.println("————————————原始棋盘——————————————");
        for (int[] row : chessArray) {
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //计算非零值个数
        int sum = 0;
        for(int[] row : chessArray){
            for(int data : row){
                if(data != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);

        //根据棋盘创建稀疏数组
        int sparseArray[][] = new int[sum+1][3];

        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 0;
        for(int i = 0;i<chessArray.length;i++){
            for(int j = 0;j<chessArray[i].length;j++){
                if(chessArray[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }

        System.out.println("---------稀疏数组-------------");
        for (int[] row : sparseArray) {
            System.out.printf("%d\t%d\t%d\t",row[0],row[1],row[2]);
            System.out.println();
        }

        //将稀疏数组存入文件
        File file=new File("E:/sparArray.txt");
        FileWriter fileWriter=new FileWriter(file);

        for(int i =0;i<sparseArray.length;i++){
            fileWriter.write(sparseArray[i][0]+"\t");
            fileWriter.write(sparseArray[i][1]+"\t");
            fileWriter.write(sparseArray[i][2]+"\t");
            fileWriter.write("\r\n");
        }

        fileWriter.close();

        //读取文件中的稀疏数组
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int r = 0;
        int sparseArray2[][] = new int[sum+1][3];

        while((line = reader.readLine()) != null){
            String temp[] = line.split("\t");
            for (int i = 0;i<temp.length;i++){
                sparseArray2[r][i] = Integer.parseInt(temp[i]);
            }
            r++;
        }
        System.out.println("-------读取的稀疏数组--------");

        for (int[] row : sparseArray2) {
            System.out.printf("%d\t%d\t%d\t",row[0],row[1],row[2]);
            System.out.println();
        }



        //根据稀疏数组还原棋盘
        int chessArray2[][] = new int[sparseArray2[0][0]][sparseArray2[0][1]];

        for(int i=1;i<sparseArray2.length;i++){
            chessArray2[sparseArray2[i][0]][sparseArray2[i][1]] = sparseArray2[i][2];
        }
        System.out.println("-------还原的棋盘--------");
        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}
