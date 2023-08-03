package Programmers.Lv1;

public class Lv1_키패드누르기 {
    public static void main(String[] args) throws Exception{

        int[] numbers ={7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));

    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int Lx = 4;
        int Ly = 1;
        int Rx = 4;
        int Ry = 3;


        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==0){
                int targetX = 4;
                int targetY = 2;
                int lSize=Math.abs(targetX-Lx)+Math.abs(targetY-Ly);
                int rSize=Math.abs(targetX-Rx)+Math.abs(targetY-Ry);

                if(lSize<rSize){
                    answer+="L";
                    Lx = targetX;
                    Ly = targetY;
                }else if(lSize>rSize){
                    answer+="R";
                    Rx = targetX;
                    Ry = targetY;
                }else{
                    if(hand.equals("right")){
                        answer+="R";
                        Rx = targetX;
                        Ry = targetY;
                    }else{
                        answer+="L";
                        Lx = targetX;
                        Ly = targetY;
                    }
                }
            }
            else if(numbers[i]%3==1){
                answer+="L";
                Lx = (int)Math.ceil((double)numbers[i]/3);
                Ly = numbers[i]%3;

            }else if(numbers[i]%3==0){
                answer+="R";
                Rx = (int)Math.ceil((double)numbers[i]/3);
                Ry = numbers[i]%3+3;
            }else{
                int targetX = (int)Math.ceil((double)numbers[i]/3);
                int targetY = 2;
                int lSize=Math.abs(targetX-Lx)+Math.abs(targetY-Ly);
                int rSize=Math.abs(targetX-Rx)+Math.abs(targetY-Ry);

                if(lSize<rSize){
                    answer+="L";
                    Lx = targetX;
                    Ly = targetY;
                }else if(lSize>rSize){
                    answer+="R";
                    Rx = targetX;
                    Ry = targetY;
                }else{
                    if(hand.equals("right")){
                        answer+="R";
                        Rx = targetX;
                        Ry = targetY;
                    }else{
                        answer+="L";
                        Lx = targetX;
                        Ly = targetY;
                    }
                }
            }
        }
        return answer;
    }
}
