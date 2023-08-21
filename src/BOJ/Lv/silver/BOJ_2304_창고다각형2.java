package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 제일 높은 기둥 기준으로 왼쪽은 오름차순으로, 오른쪽은 내림차순으로..
 */
public class BOJ_2304_창고다각형2 {

    static class LH{
        int l, h;

        public LH(int l, int h) {
            this.l = l;
            this.h = h;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<LH> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            arr.add(new LH(L, H));
        }

        Collections.sort(arr, (o1, o2) -> o1.l - o2.l);

        int sum=0;
        int max =0;

        // 처음부터 끝까지 다 돌아보고 최대 기둥 높이 찾기
        LH lh = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            LH current = arr.get(i);

            if (lh.h <= current.h) {
                sum += (current.l - lh.l) * lh.h;
                lh= current;
                max = i;
            }
        }

        // 끝에서부터 최대 높이 기둥 직전까지
        lh = arr.get(arr.size() - 1);
        for (int i = 1; i < arr.size() - max; i++) {
            LH current = arr.get(arr.size()-1-i);

            if (lh.h <= current.h) {
                sum += (lh.l - current.l) * lh.h;
                lh = current;
            }
        }

        sum += arr.get(max).h;

        System.out.println("sum = " + sum);
    }
}
