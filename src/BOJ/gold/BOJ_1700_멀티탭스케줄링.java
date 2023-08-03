package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 그리디 알고리즘
 * 페이지 교체 알고리즘
 */
public class BOJ_1700_멀티탭스케줄링 {

    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] plug = new int[K];
        int ans=0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            plug[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            for (int i = 1; i < K; i++) {
                if (plug[i] != plug[i - 1]) {
                    ans++;
                }
            }
        } else {
            HashSet<Integer> multitap = new HashSet<>();

            for (int i = 0; i < K; i++) {
                if (multitap.contains(plug[i])) {
                    continue;
                }

                if (multitap.size() < N) {
                    multitap.add(plug[i]);
                } else {
                    HashSet<Integer> temp = new HashSet<>(multitap);

                    for (int j = i + 1; j < K; j++) {
                        if (temp.contains(plug[j])) {
                            temp.remove(plug[j]);
                        }
                        if (temp.size() == 1) {
                            break;
                        }
                    }

                    multitap.remove(temp.iterator().next());
                    multitap.add(plug[i]);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
