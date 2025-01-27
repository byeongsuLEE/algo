package day250127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-01-27
 * 풀이방법:
 * 두 수열의 공통 원소 중 가장 큰 값을 선택
 * 해당 원소의 다음 부분수열로 탐색을 계속

 */

public class Main_30805 {
    private static int[] A;
    private static int[] B;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열 A 입력
        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 수열 B 입력
        int m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solution() {
        List<Integer> result = new ArrayList<>();
        int indexA = 0, indexB = 0;

        while (indexA < A.length && indexB < B.length) {
            int maxCommon = -1;
            int nextIndexA = -1, nextIndexB = -1;

            // 공통 원소 중 가장 큰 값 찾기
            for (int i = indexA; i < A.length; i++) {
                for (int j = indexB; j < B.length; j++) {
                    if (A[i] == B[j] && A[i] > maxCommon) {
                        maxCommon = A[i];
                        nextIndexA = i;
                        nextIndexB = j;
                    }
                }
            }

            if (maxCommon == -1) {
                break; // 더 이상 공통 원소가 없음
            }

            result.add(maxCommon);
            indexA = nextIndexA + 1;
            indexB = nextIndexB + 1;
        }

        // 결과 출력
        System.out.println(result.size());
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
