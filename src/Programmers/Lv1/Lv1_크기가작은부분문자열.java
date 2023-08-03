package Programmers.Lv1;

public class Lv1_크기가작은부분문자열 {
    public static void main(String[] args){
        String t = "10203";
        String p = "15";
        System.out.println(solution(t,p));
    }

    public static int solution(String t, String p) {
        int answer = 0;
        String str="";
        for(int i=0; i<t.length()-p.length()+1; i++){
            str = t.substring(i, i+p.length());
            System.out.println("str = " + str);
            if(str.compareTo(p)<=0){
                answer++;
            }
        }
        return answer;
    }
}
