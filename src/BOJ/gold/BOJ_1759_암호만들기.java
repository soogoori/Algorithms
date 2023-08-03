package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 순열 -> DFS
 */
public class BOJ_1759_암호만들기 {

    static String aeiou = "aeiou";
    static String[] code;
    static boolean visited[];
    static int jaCnt, moCnt;
    static int L, C;

    static void find(int s, int cnt) {

        // 해당 조건 만족하는지 확인 (자음 최소 2개, 모음 최소 1개)
        if(cnt==L){
            jaCnt=0;
            moCnt=0;
            String possible = "";
            for(int i=0; i<C; i++){
                if (visited[i]) {
                    possible+=code[i];

                    if (aeiou.contains(code[i])) {
                        moCnt++;
                    }else{
                        jaCnt++;
                    }
                }
            }
            if(moCnt>=1 && jaCnt>=2){
                System.out.println(possible);
            }
        }

        // 순열 방식.
        for(int i=s; i<C; i++){
            visited[i] = true;
            find(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        code = new String[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            code[i] = st.nextToken();
        }

        // 사전식으로 배열되어야하므로 미리 오름차순으로 sort
        Arrays.sort(code);
        find(0, 0);
    }
}
