package com.njsf;

public class E_B_MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0;i < 7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for(int j = 0; j < 8; j++){
            map[j][0] = 1;
            map[j][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;


        setWay2(map,1,1);

        for (int[] i : map) {
            for (int j : i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }


    }

    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){
                map[i][j] = 2;
                //看该点下右上做是否有路
                if(setWay(map,i+1,j)){
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else{
                    //死路置为3
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    public static boolean setWay2(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(setWay2(map,i-1,j)){
                    return true;
                }else if(setWay2(map,i,j+1)){
                    return true;
                }else if(setWay2(map,i+1,j)){
                    return true;
                }else if(setWay2(map,i,j-1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
