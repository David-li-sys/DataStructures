package com.njsf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class J_A_Graph {
    private ArrayList<String> vertexList;//图的节点集合
    private int[][] edges;//图对应的邻接矩阵
    private int numOfEdges;//边的数目
    private boolean[] isVisited ;

    public static void main(String[] args) {
        int n = 5;
        String[] vertexList = {"A", "B", "C", "D", "E"};
        J_A_Graph graph = new J_A_Graph(n);
        for (String value : vertexList) {
            graph.insertVertex(value);
        }

        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();

        graph.dfs();
        System.out.println();
        System.out.println("-------------------------");

        graph.bfs();

    }

    public J_A_Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;


    }

    public int getFirstNeighbor(int index){
        for(int j = 0; j < vertexList.size(); j++){
            if(edges[index][j] > 0){
                return j;
            }

        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2){
        for(int j = v2 + 1; j < vertexList.size(); j++){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    public void dfs(boolean[] isVisited, int i){
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while(w != -1){
            if(!isVisited[w]){
                dfs(isVisited, w);
            }

            w= getNextNeighbor(i , w);
        }

    }

    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        for(int i = 0; i < getNumOfVertex(); i++){
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    private void bfs(boolean[] isVisited, int i){
        int u;
        int w;
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        queue.addLast(i);
        while(!queue.isEmpty()){
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while(w != -1){
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }
        }

    }

    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for(int i =0; i <getNumOfVertex(); i++){
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    public int getNumOfVertex(){
        return vertexList.size();
    }

    public int getNumOfEdges(){
        return numOfEdges;
    }

    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    public void showGraph(){
        for(int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;

        numOfEdges++;

    }



}
