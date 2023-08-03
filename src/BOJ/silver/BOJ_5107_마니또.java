package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_5107_마니또 {

    static int[][] map;
    static boolean[] visit;
    static int cnt;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());

            if(N==0)    return;
            map = new int[N][N];
            visit = new boolean[N];
            cnt = 0;
            ArrayList<String> name = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                if (!name.contains(a)) {
                    name.add(a);
                }
                if (!name.contains(b)) {
                    name.add(b);
                }

                map[name.indexOf(a)][name.indexOf(b)] = 1;
            }

            for (int i = 0; i < N; i++) {
                if (!visit[i]) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] == 1 && !visit[i]) {
                            visit[i] = true;
                            solution(j);
                        }
                    }
                }
            }
            System.out.println(T + " " + cnt);
            T++;
        }
    }

    static void solution(int x) {
        visit[x] = true;
        for (int i = 0; i < N; i++) {
            if (map[x][i] == 1) {
                if (!visit[i]) {
                    solution(i);
                } else {
                    cnt++;
                }
                break;
            }
        }
    }
}
