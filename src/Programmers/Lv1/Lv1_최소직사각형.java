package Programmers.Lv1;

public class Lv1_최소직사각형 {
    public static void main(String[] args){
        int[][] sizes= {{10,7}, {12,3}, {8,15},{14,7},{5,15}};
        System.out.println(solution(sizes));
    }
    public static int solution(int[][] sizes) {
        int answer = 1;
        int w=0;
        int h=0;

        int max = 0;
        int maxIdxI=0;
        int maxIdxJ=0;
        int maxOpp=0;

        for(int i=0; i<sizes.length; i++){
            for(int j=0; j<2; j++){
                if(sizes[i][j]>max){
                    max = sizes[i][j];
                    w=max;
                    maxIdxI = i;
                    maxIdxJ = j;
                }
            }
        }

        if(maxIdxJ==0){
            maxOpp=1;
        }else   maxOpp=0;

        max = sizes[maxIdxI][maxOpp];

        for(int i=0; i<sizes.length; i++){
            if(Math.min(sizes[i][0],sizes[i][1])>=max){
                max = Math.min(sizes[i][0],sizes[i][1]);
                h=max;
            }
        }

        answer=h*w;

        return answer;
    }

}
