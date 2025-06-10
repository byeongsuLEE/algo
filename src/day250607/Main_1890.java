package day250607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-07
 * 풀이방법
 **/


public class Main_1890 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {
        long dp[][] = new long[N + 1][N + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                //마지막 값일 떄는 제외
                if (map[i][j] == 0) break;
                int downValue = i + map[i][j];
                int leftValue = j + map[i][j];

                if (downValue <= N) {
                    dp[downValue][j] += dp[i][j];
                }

                if (leftValue <= N) {
                    dp[i][leftValue] += dp[i][j];
                }

            }
        }
        sb.append(dp[N][N]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }


}
