package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 해시맵
 * 그냥 ArrayList 사용하면 시간 초과 발생.
 */
public class BOJ_1764_듣보잡 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashListen = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            hashListen.put(br.readLine(), 1);
        }

        for (int i = 0; i < M; i++) {
            String seeName = br.readLine();
            hashListen.put(seeName, hashListen.getOrDefault(seeName, 0) + 1);
            if (hashListen.get(seeName) == 2) {
                list.add(seeName);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());

        for (String s : list) {
            System.out.println(s);
        }
    }
}
