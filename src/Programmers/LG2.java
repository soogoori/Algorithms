package Programmers;

public class LG2 {
    public static void main(String[] args){
        String s = "dfgsergdhdghfjrjdtyjdthdfgh";
        int[][] interval = {{4,5},{1, 2}, {3, 3}};

        System.out.println(solution(s,interval));
    }

    public static String solution(String s, int[][] interval){
        String answer = "";
        String str = "";
        String str1 = "", str2 = "";
        for (int i = 0; i < interval.length; i++) {
            str = s.substring(interval[i][0]-1, interval[i][1]);
            str = new StringBuilder(str).reverse().toString();
            str1 = s.substring(0, interval[i][0]-1);
            str2 = s.substring(interval[i][1]);

            s = str1+str+str2;

            System.out.println("s = " + s);
        }
        answer=s;
        return answer;
    }

}
