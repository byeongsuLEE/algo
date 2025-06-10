package day250428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-28
 * 풀이방법
 * 매개변수 탐색 - 거리 기준으로 이분 탐색
 **/

public class Main_2110 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int C;
    private static int[] house;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {
        int start = 1; // 최소 거리 (0은 의미 없으니 1부터)
        int end = house[N - 1] - house[0]; // 가장 먼 거리
        int answer = 0;

        while (start <= end) {
            int mid = (start + end) / 2; // 거리 후보 (mid)
            int installed = 1; // 첫 번째 집에 무조건 설치
            int lastInstalled = house[0]; // 마지막 설치한 위치

            // 공유기 설치
            for (int i = 1; i < N; i++) {
                if (house[i] - lastInstalled >= mid) { // mid 이상의 거리라면 설치
                    installed++;
                    lastInstalled = house[i];
                }
            }

            if (installed >= C) { // 공유기를 충분히 설치했으면
                answer = mid; // 거리 기록
                start = mid + 1; // 더 크게 시도
            } else {
                end = mid - 1; // 거리가 너무 커서 설치 실패 → 거리 줄이기
            }
        }
        sb.append(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
    }
}
