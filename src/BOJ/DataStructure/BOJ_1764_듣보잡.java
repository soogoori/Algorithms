package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * HashMap or HashSet
 * https://www.baeldung.com/java-hashset-arraylist-contains-performance
 */
public class BOJ_1764_듣보잡 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();

        /*HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                answer.add(str);
            }
        }*/

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
            if(map.get(name)==2) answer.add(name);
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
