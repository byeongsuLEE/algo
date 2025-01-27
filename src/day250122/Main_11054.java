package day250122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11054 {
    private static int N;
    private static int[] numbers;
    private static int[] dpLeft;
    private static int[] dpRight;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        // dpLeft 계산: 0부터 i까지의 증가 부분 수열 길이
        for (int i = 0; i < N; i++) {
            dpLeft[i] = 1; // 자기 자신만 포함
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dpLeft[i] = Math.max(dpLeft[i], dpLeft[j] + 1);
                }
            }
        }

        // dpRight 계산: N-1부터 i까지의 감소 부분 수열 길이
        for (int i = N - 1; i >= 0; i--) {
            dpRight[i] = 1; // 자기 자신만 포함
            for (int j = N - 1; j > i; j--) {
                if (numbers[j] < numbers[i]) {
                    dpRight[i] = Math.max(dpRight[i], dpRight[j] + 1);
                }
            }
        }

        // 가장 긴 바이토닉 수열 길이 계산
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, dpLeft[i] + dpRight[i] - 1);
        }

        System.out.println(maxLength);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        dpLeft = new int[N];
        dpRight = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }
}
