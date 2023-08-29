package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1027_고층건물 {

    static int N;
    static int[] buildings;
    static int[] answer;

    static double getSlope(int x, int y) {
        return (double) (buildings[y] - buildings[x]) / (y - x);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        answer = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N-1; i++) {
            answer[i]++;
            answer[i+1]++;
            double slope = buildings[i + 1] - buildings[i];
            for (int j = i + 2; j < N; j++) {
                double nextSlope = getSlope(i, j);
                if (nextSlope > slope) {
                    slope = nextSlope;
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < answer.length; i++) {
            max = Math.max(answer[i], max);
        }
        System.out.println(max);
    }
}
