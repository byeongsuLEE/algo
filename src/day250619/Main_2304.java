package day250619;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-19
 * 풀이방법 : 가장 높은 기둥을 기준으로 각 위치별로 높이를 계산
 **/

public class Main_2304 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static ArrayList<int[]> input;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {
        // 1. 가장 높은 기둥 찾기
        int maxHeight = 0;
        int maxIndex = 0;

        for (int i = 0; i < N; i++) {
            if (input.get(i)[1] > maxHeight) {
                maxHeight = input.get(i)[1];
                maxIndex = i;
            }
        }

        int totalArea = 0;
        int startPos = input.get(0)[0];
        int endPos = input.get(N - 1)[0];

        // 2. 각 위치별로 높이 계산하여 면적 구하기
        for (int pos = startPos; pos <= endPos; pos++) {
            int height = 0;

            // 현재 위치가 최고점 왼쪽이거나 최고점인 경우
            if (pos <= input.get(maxIndex)[0]) {
                for (int i = 0; i <= maxIndex; i++) {
                    if (input.get(i)[0] <= pos && input.get(i)[1] > height) {
                        height = input.get(i)[1];
                    }
                }
            }
            // 현재 위치가 최고점 오른쪽인 경우
            else {
                for (int i = N - 1; i > maxIndex; i--) {
                    if (input.get(i)[0] >= pos && input.get(i)[1] > height) {
                        height = input.get(i)[1];
                    }
                }
            }

            totalArea += height;
        }

        sb.append(totalArea);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        input = new ArrayList<int[]>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(input, (a, b) -> Integer.compare(a[0], b[0]));
    }
}