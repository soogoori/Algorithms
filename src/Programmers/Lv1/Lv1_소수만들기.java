package Programmers.Lv1;

public class Lv1_소수만들기 {

    static boolean[] prime = new boolean[3001];

    public static void main(String[] args){

        int[] nums = {1, 2, 7, 6, 4};
        isPrime();

        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        int cnt= 0;

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    if (!prime[nums[i]+nums[j]+nums[k]]) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    static void isPrime(){
        for (int i = 2; i <= 3000; i++) {
            for (int j = i * 2; j <= 3000; j += i) {
                prime[j]=true;
            }
        }
    }




    /*public static int solution(int[] nums) {
        int answer = 0;
        int prime=0;
        int cnt=0;

        for(int i=0; i<=nums.length-3; i++){
            for(int j=i+1; j<=nums.length-2; j++){
                for(int l=j+1; l<=nums.length-1;){
                    prime=0;
                    cnt=0;
                    prime=nums[i]+nums[j] + nums[l];

                    for(int k=2; k<=Math.sqrt(prime); k++){
                        if(prime%k==0){
                            cnt++;
                        }
                    }
                    if(cnt==2){
                        answer++;
                    }
                }

            }
        }
        return answer;
    }*/
}
