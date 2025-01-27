package day250109;

import java.io.IOException;
import java.util.Scanner;

public class Main_2448 {
    private static boolean[][] map;
    private static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int width = 2 * N - 1;
        map = new boolean[N][width];

        recur(N, 0, width / 2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(map[i][j] ? "*" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void recur(int n, int y, int x) {
        if (n == 3) {
            makeTriangle(y, x);
            return;
        }

        int half = n / 2;

        // 위쪽 삼각형
        recur(half, y, x);

        // 왼쪽 아래 삼각형
        recur(half, y + half, x - half);

        // 오른쪽 아래 삼각형
        recur(half, y + half, x + half);
    }

    private static void makeTriangle(int y, int x) {
        map[y][x] = true;
        map[y + 1][x - 1] = true;
        map[y + 1][x + 1] = true;
        for (int i = -2; i <= 2; i++) {
            map[y + 2][x + i] = true;
        }
    }
}
