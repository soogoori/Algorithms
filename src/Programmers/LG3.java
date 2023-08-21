package Programmers;

import java.util.*;

public class LG3 {
    static ArrayList<int[][]> ans;
    static ArrayList<Info>[] list;

    static class Info implements Comparable<Info>{
        int dataNum, day;

        public Info(int dataNum, int day) {
            this.dataNum = dataNum;
            this.day = day;
        }

        @Override
        public int compareTo(Info o) {
            return dataNum-o.dataNum;
        }
    }
    public static void main(String[] args){
        int n=3;
        int m =5;
        int[][] records = {{1, 1, 5}, {2, 4, 7}, {1, 5, 10}, {3, 1, 10},
                {2, 1, 5}, {1, 3, 3}, {3, 2, 8}, {2, 2, 8}, {3, 4, 7}};

        solution(n,m,records);
    }

    public static int[][] solution(int n, int m, int[][] records){

        list = new ArrayList[n+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        int [][] answer={};
        ans = new ArrayList<>();

        for (int i = 0; i < records.length; i++) {
            list[records[i][0]].add(new Info(records[i][1], records[i][2]));
        }

        for (int i =0; i<records.length; i++) {
            int data=records[i][1];

            int cnt=0;
            int max=records[i][2];
            for (int j = i + 1; j < records.length; j++) {
                if (data == records[j][1]) {
                    max = Math.max(max, records[j][2]);
                    cnt++;
                }
            }
            if (cnt == 1) {

            }else{

            }
        }

        return answer;
    }


    static void check2(int[][] records, ArrayList<int[]> list){

    }

    static void check3(int[][] records, ArrayList<int[]> list){

    }

}
