package day250604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-04
 * 풀이방법
 **/


public class Main_9184 {
    private static StringBuilder sb = new StringBuilder();
    private static int dp[][][];

    public static void main(String[] args) throws IOException {
        initSolution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {
        dp = new int[51][51][51];


        for (int a = 0; a <= 20; a++) {
            for (int b = 0; b <= 20; b++) {
                for (int c = 0; c <= 20; c++) {

                    if (a == 0 || b == 0 || c == 0) {
                        dp[a][b][c] = 1;
                    } else if (a < b && b < c) {
                        dp[a][b][c] = dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];
                    } else {
                        dp[a][b][c] = dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c - 1];

                    }
                }
            }
        }

    }

    private static void initSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        solution();

        String str;
        while (true) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;
            sb.append("w("+a+", "+b+", "+c+") = ");
            if(a <=0 || b<= 0 || c <= 0) {
                sb.append(1);
            }
            else if (a > 20 || b > 20 || c > 20) {
                sb.append(dp[20][20][20]);
            }

            else {
                sb.append(dp[a][b][c]);
            }
            sb.append("\n");


        }

    }

}
