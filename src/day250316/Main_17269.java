package day250316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-16
 * 풀이방법
 **/


public class Main_17269 {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[][] totalNameWriteCount;
    private static int []  alpahWriteCount = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        for (int i = 0; i < N + M; i++) {
            for (int j = 0; j < N + M - i - 1; j++) {
                totalNameWriteCount[i + 1][j] = (totalNameWriteCount[i][j] + totalNameWriteCount[i][j + 1]) % 10;
            }
            if (N + M - i - 1 == 2) {
                totalNameWriteCount[i + 1][0] = totalNameWriteCount[i + 1][0] == 0 ? 0 : totalNameWriteCount[i + 1][0] * 10;
                int answer = (totalNameWriteCount[i + 1][0] + totalNameWriteCount[i + 1][1]) ;
                sb.append(answer).append("%");
                System.out.println(sb.toString());
                return;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        totalNameWriteCount = new int[N + M][N + M];
        int totalIndex = 0;
        for (int i = 0; i < N + M; i++) {
            if (i < N) {
                int num = A.charAt(i) - 'A';
                totalNameWriteCount[0][totalIndex++] = alpahWriteCount[num];
            }
            if (i < M) {
                int num = B.charAt(i) - 'A';
                totalNameWriteCount[0][totalIndex++] = alpahWriteCount[num];
            }
        }
    }

}
