package Programmers.Lv2;

/**
 *  미해결 - 투포인터
 */
public class Lv2_연속된부분수열의합 {
    public static void main(String[] args) {
        int[] sequence ={2,2,2,2,2};
        int k=6;

        solution(sequence, k);
    }
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int l=0;
        int r=0;
        int sum=0;
        int min = Integer.MAX_VALUE;
        sum = sequence[l];

        while(l<sequence.length && r<sequence.length) {
            if (sum < k) {
                r++;
                if(r==sequence.length){
                    break;
                }
                sum += sequence[r];

            } else if (sum == k) {
                if (min > Math.abs(r - l)) {
                    min = Math.abs(r - l);
                    answer[0] = l;
                    answer[1] = r;
                }

                sum -= sequence[l++];
                r++;
                if (r == sequence.length) {
                    break;
                }
                sum += sequence[r];

            } else {
                sum -= sequence[l++];
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }
        return answer;
    }
}
