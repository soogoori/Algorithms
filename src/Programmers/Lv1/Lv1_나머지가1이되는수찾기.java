package Programmers.Lv1;

public class Lv1_나머지가1이되는수찾기 {
    public static void main(String[] args){
        System.out.println(solution(10));
    }

    public static int solution(int n) {
        int answer = 0;
        int x =1;

        while(true){
            if(n%x==1){
                answer = x;
                break;
            }
            x++;
        }
        return answer;
    }

}
