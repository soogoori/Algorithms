package Programmers.Lv1;

public class Lv1_삼총사 {
    public static void main(String[] args){
        int[] arr = {-1, 1, -1, 1};
        System.out.println(solution(arr));
    }

    public static int solution(int[] number) {
        int answer = 0;
        int i, j, k;

        for(i=0; i<number.length-2; i++){
            int sum=number[i];
            for(j=i+1; j<number.length-1; j++){
                sum+=number[j];
                for(k= j+1; k<number.length; k++){
                    sum+=number[k];
                    if(sum==0){
                        answer++;
                    }
                    sum-=number[k];
                }
                --k;
                sum-=number[j];
            }
            --j;
        }
        return answer;
    }
}
