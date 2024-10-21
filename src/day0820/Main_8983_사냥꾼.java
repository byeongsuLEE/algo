package day0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자 : user 작성날짜 : 2024-08-20 설명 : 1. x좌표를 정렬한다. 2. 이분탐색을 x축인 사대에서 수행하여
 * 사정거리 내에 있는 동물의 수를 구한다.
 */
public class Main_8983_사냥꾼 {

    public static class Point implements Comparable<Point> {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" + "r=" + r + ", c=" + c + '}';
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.c, o.c); // c를 기준으로 정렬
        }
    }

    public static StringTokenizer st;
    private static int M; // 사대의 수
    private static int N; // 동물의 수
    private static int L; // 사정거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // 사대 위치 입력
        st = new StringTokenizer(br.readLine());
        int[] shotPoints = new int[M];
        for (int i = 0; i < M; i++) {
            shotPoints[i] = Integer.parseInt(st.nextToken());
        }

        // 사대 위치 정렬
        Arrays.sort(shotPoints);

        // 동물 위치 입력
        Point[] animals = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); // x좌표
            int r = Integer.parseInt(st.nextToken()); // y좌표
            animals[i] = new Point(r, c);
        }

        // 사냥할 수 있는 동물 수 계산
        int count = 0;

        for (Point animal : animals) {
            int x = animal.c;
            int y = animal.r;


            int searchShotIndex = binarySearchClosest(shotPoints, x);

            // 가장 가까운 사대가 사정거리 내에 있는지 확인
            boolean isInRange = false;

            // 오른쪽 사대 체크
            if (searchShotIndex < M && Math.abs(shotPoints[searchShotIndex] - x) + y <= L) {
                isInRange = true;
            }

            // 왼쪽 사대 체크
            if (searchShotIndex > 0 && Math.abs(shotPoints[searchShotIndex - 1] - x) + y <= L) {
                isInRange = true;
            }

            // 사정거리 내에 있으면 count 증가
            if (isInRange) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }

    // 이분 탐색으로 동물의 x좌표에 가장 가까운 사대의 인덱스를 찾는 함수
    public static int binarySearchClosest(int[] shotPoints, int target) {
        int left = 0;
        int right = shotPoints.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (shotPoints[mid] == target) {
                return mid; // 정확히 일치하는 사대를 찾은 경우
            } else if (shotPoints[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}