package Programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 정규표현식 regex 활용
 */
public class Lv1_신규아이디추천 {
    static Integer[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static Character[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
                            'h', 'i', 'j', 'k', 'l', 'm', 'n',
                            'o', 'p', 'q', 'r', 's', 't', 'u',
                            'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) throws Exception {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(new_id));
    }

    public static String solution(String new_id) {
       //String answer = "";
        List<Integer> numList = new ArrayList<>(Arrays.asList(num));
        List<Character> alphaList = new ArrayList<>(Arrays.asList(alpha));

        // 1단계 : 모든 대문자를 소문자로 치환
        new_id = new_id.toLowerCase();

        System.out.println("new_id1 = " + new_id);

        // 2단계 : 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 제외한 모든 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9-._]", "");

        System.out.println("new_id2 = " + new_id);

        // 3단계 : 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        new_id = new_id.replaceAll("\\.+", ".");

        System.out.println("new_id3 = " + new_id);

        // 4단계 : 마침표(.)가 처음이나 끝에 위치한다면 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        System.out.println("new_id4 = " + new_id);

        // 5단계 : 빈 문자열이라면, new_id에 "a" 대입
        if(new_id.length()==0){
            new_id += "a";
        }

        System.out.println("new_id5 = " + new_id);


        // 6단계 : 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        new_id = new_id.replaceAll("[.]$", "");

        System.out.println("new_id6 = " + new_id);

        // 7단계 : 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
        if(new_id.length() <= 2){
            int idx = new_id.length()-1;
            while (new_id.length() != 3) {
                new_id += new_id.charAt(idx);
            }
        }

        System.out.println("new_id7 = " + new_id);

        return new_id;
    }
}
