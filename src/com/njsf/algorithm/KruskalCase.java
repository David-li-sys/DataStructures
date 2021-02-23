package com.njsf.algorithm;

import java.util.Arrays;

public class KruskalCase {
    private int edgeNum;
    private char[] vertexs;
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A','B','C','D','E','F','G'};
        int[][] matrix = {
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };

        KruskalCase kruskalCase = new KruskalCase(vertexs,matrix);
        kruskalCase.print();
        kruskalCase.kruskal();


    }


    public KruskalCase(char[] vertexs, int[][] matrix){
        int vlen = vertexs.length;

        this.vertexs = new char[vlen];
        for(int i = 0;i < vertexs.length; i++){
            this.vertexs[i] = vertexs[i];
        }

        this.matrix = new int[vlen][vlen];

        for(int i = 0; i < vlen; i++){
            for(int j = 0; j < vlen; j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }

        for(int i =0; i < vlen; i++){
            for(int j = i+1; j < vlen; j++){
                if(this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal(){
        int index = 0;
        int[] ends = new int[edgeNum];

        EData[] rets = new EData[edgeNum];

        EData[] edges = getEdges();
        sortEdges(edges);

        for(int i = 0; i < edgeNum; i++){
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            if(m != n){
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }

        for (EData ret : rets) {
            if(ret != null){
                System.out.println("<" + ret.start + "," + ret.end + "> = " + ret.weight);
            }
        }

    }

    public void print(){
        System.out.println("邻接矩阵为：");
        for(int i = 0; i < vertexs.length; i++){
            for(int j = 0; j < vertexs.length; j++){
                System.out.printf("%10d\t",matrix[i][j]);
            }
            System.out.println();
        }
    }


    public void sortEdges(EData[] edges){
        for(int i = 0; i < edges.length - 1; i++){
            for(int j = 0; j < edges.length - 1 - i; j++){
                if(edges[j].weight > edges[j + 1].weight){
                    EData temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }

    private int getPosition(char ch){
        for(int i = 0; i < vertexs.length; i++){
            if(vertexs[i] == ch){
                return i;
            }
        }

        return -1;
    }

    private EData[] getEdges(){
        int indes = 0;
        EData[] edges = new EData[edgeNum];
        for(int i = 0; i < vertexs.length; i++){
            for(int j = i+1; j < vertexs.length; j++){
                if(matrix[i][j] != INF){
                    edges[indes] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                    indes++;
                }
            }
        }
        return edges;

    }

    private int getEnd(int[] ends, int i){
        while(ends[i] != 0){
            i = ends[i];
        }

        return i;
    }
}

class EData{
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;

    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
