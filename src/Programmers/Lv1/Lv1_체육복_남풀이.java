package Programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv1_체육복_남풀이 {
    public static void main(String[] args){
        int n=5;
        Integer[] lost = {2,4};
        Integer[] reserve = {1,3,5};

        System.out.println(solution(n,lost, reserve));
    }

    public static int solution(int n, Integer[] lost, Integer[] reserve) {
        int answer = 0;

        // 1.lost와 reserve 배열 정렬
        // 2. lost와 reserve에 중복으로 포함되어있는 요소 제거
        Arrays.sort(lost);
        Arrays.sort(reserve);

        ArrayList<Integer> lostArr = new ArrayList<>(Arrays.asList(lost));
        ArrayList<Integer> reserveArr = new ArrayList<>(Arrays.asList(reserve));

        for(int i=0; i<reserveArr.size(); i++){
            if (lostArr.contains(reserveArr.get(i))) {
                lostArr.remove(reserveArr.get(i));
                reserveArr.remove(reserveArr.get(i));
            }
        }

        while(true){
            if(lostArr.isEmpty()){
                break;
            }else if(reserveArr.isEmpty()){
                answer+=lostArr.size();
                break;
            }
            else if(Math.abs(lostArr.get(0)-reserveArr.get(0))==1){
                answer++;
                lostArr.remove(lostArr.get(0));
                reserveArr.remove(reserveArr.get(0));
            }
        }
        return n-answer;
    }
}
