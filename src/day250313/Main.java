package day250313;

import java.io.*;
import java.util.*;

public class Main
{
    static long x, y;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        StringBuilder sb = new StringBuilder();

        // Case 1: x == y → 문제 조건상 반드시 연산 2번 필요
        if (x == y) {
            sb.append(2).append("\n");
            sb.append(x).append("\n").append(-x);
            System.out.println(sb);
            return;
        }

        long diff = y - x;

        // Case 2: GCD(x, y - x) != 1 → 1번 연산으로 해결
        if (diff != 0 && gcd(x, diff) != 1) {
            sb.append(1).append("\n").append(diff);
            System.out.println(sb);
            return;
        }

        // Case 3: x의 약수를 z1로 시도 → x+z1 후 GCD(x2, z2) 확인
        for (long d = 2; d * d <= x; d++) {
            if (x % d != 0) continue;

            long[] candidates = {d, x / d};
            for (long z1 : candidates) {
                if (z1 == 0) continue;

                long x2 = x + z1;
                long z2 = y - x2;

                if (z2 != 0 && gcd(x2, Math.abs(z2)) != 1) {
                    sb.append(2).append("\n")
                            .append(z1).append("\n")
                            .append(z2);
                    System.out.println(sb);
                    return;
                }
            }
        }

        // Case 4: fallback 처리 (x가 소수 등에서 빠져나오지 못한 경우)
        long z1 = x;
        long x2 = x + z1;
        long z2 = y - x2;

        if (z2 == 0 || gcd(x2, Math.abs(z2)) == 1) {
            z1 = 2;
            x2 = x + z1;
            z2 = y - x2;
        }

        sb.append(2).append("\n")
                .append(z1).append("\n")
                .append(z2);
        System.out.println(sb);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
    }
}
