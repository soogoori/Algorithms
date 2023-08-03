package Programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv1_체육복 {
    public static void main(String[] args){
        int n=3;
        Integer[] lost = {3};
        Integer[] reserve = {1};

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
        int lostSize = 0;
        int reserveSize = 0;

        for(int i=0; i<n; i++){
            if(lostArr.isEmpty()){
                answer++;
            }else if(reserveArr.isEmpty() && !lostArr.isEmpty() && (i+1)==lostArr.get(lostSize)){
                continue;
            }
            else if(i+1 == lostArr.get(lostSize)){
                int gap = reserveArr.get(reserveSize)-lostArr.get(lostSize);
                if(gap== -1 || gap==1 || gap==0){
                    answer++;
                    reserveArr.remove(reserveArr.get(reserveSize));
                    lostArr.remove(lostArr.get(lostSize));
                }else{
                    lostArr.remove(lostSize);
                }
            }
            else{
                answer++;
            }
        }
        return answer;
    }
}
