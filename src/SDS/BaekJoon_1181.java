package SDS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BaekJoon_1181 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] strArr = new String[N];

        for(int i=0; i<N; i++){
            strArr[i] = sc.next();
        }

        // Comparator 인터페이스 구현치를 메서드의 추가 인자로 넘김 -> 새로운 정렬 기준으로 객체 정렬
        // Comparator는 기본적으로 오름차순 -> 순서 변경하고자 하면 양수 return
        // -> 순서 냅두려면 음수 return
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    // compareTo(stringB) -> 0보다 작으면 o1이 o2보다 앞에 옴
                    // 0보다 크면 o1이 o2보다 뒤에 옴
                    // o1이 더 크면 양수, o1이 더 작으면 음수
                    return o1.compareTo(o2);
                }else{
                    // 음수 => o1이 더 짧음 => 더 앞에 옴
                    // 양수 => o1이 더 긺 => 더 뒤에 옴
                    return o1.length()-o2.length();
                }
            }
        });

        System.out.println(strArr[0]);

        for(int i =1; i<N; i++){
            if(!strArr[i].equals(strArr[i-1])){
                System.out.println(strArr[i]);
            }
        }
    }

}
