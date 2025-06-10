package day250423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-23
 * 풀이방법
 *
 *
 **/


public class Main_2529 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static char[] input;
    private static int[] selected;
    private static Long maxValue = Long.MIN_VALUE;
    private static Long minValue = Long.MAX_VALUE;
    private static String maxString;
    private static String minString;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        sb.append(maxString).append('\n');
        sb.append(minString);
        System.out.println(sb.toString());
    }

    private static void solution() {
        permutation(0);
    }

    private static void permutation(int cnt) {
        if (cnt == N + 1) {
            String num = "";
            for (int i = 0; i < N + 1; i++) {
                num += selected[i];
            }
            long number = Long.parseLong(num);

            if (maxValue < number) {
                maxValue = number;
                maxString = num;
            }

            if (minValue > number) {
                minValue = number;
                minString = num;
            }


            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (cnt == 0) {
                if (visited[i]) continue;
                visited[i] = true;
                selected[cnt] = i;
                permutation(cnt + 1);
                visited[i] = false;
            } else {
                int beforeNum = selected[cnt - 1];
                if (canSelectNum(input[cnt - 1], beforeNum, i)) {
                    if (visited[i]) continue;
                    visited[i] = true;
                    selected[cnt] = i;
                    permutation(cnt + 1);
                    visited[i] = false;
                }
            }
        }

    }

    private static boolean canSelectNum(char ch, int beforeNum, int curNum) {
        if (ch == '>' && beforeNum > curNum) {
            return true;
        } else if (ch == '<' && beforeNum < curNum) {
            return true;
        } else {
            return false;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        input = new char[N];
        selected = new int[N + 1];
        visited = new boolean[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = st.nextToken().charAt(0);
        }
    }
}

