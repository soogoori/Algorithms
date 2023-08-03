package Programmers.Lv2;

/**
 * 구현
 */
public class Lv2_스킬트리 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String cur : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cur.length(); i++) {
                if (skill.contains(cur.charAt(i) + "")) {
                    sb.append(cur.charAt(i));
                }
            }
            answer += skill.indexOf(sb.toString()) == 0 ? 1 : 0;
        }

        return answer;
    }
}
