package day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자   : user
 * 작성날짜 : 2024-08-26
 * 설명    : 계란으로 계란치기 (DFS 탐색 기반)
 */
public class Main_16987 {

    private static int N;
    private static int answer;
    private static Egg[] eggs;

    public static class Egg {
        int strength; // 내구도
        int weight;   // 무게

        public Egg(int strength, int weight) {
            this.strength = strength;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Egg{" +
                    "strength=" + strength +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int strength = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(strength, weight);
        }

        // 초기화 및 DFS 탐색 시작
        answer = 0;
        dfs(0);
        System.out.println(answer);
    }

    // dfs 메서드
    private static void dfs(int current) {
        // 마지막 계란까지 탐색이 완료되었을 경우
        if (current == N) {
            int brokenCount = 0;
            for (Egg egg : eggs) {
                if (egg.strength <= 0) {
                    brokenCount++;
                }
            }
            answer = Math.max(answer, brokenCount);  // 최대값 갱신
            return;
        }

        // 현재 들고 있는 계란이 이미 깨진 상태라면 다음 계란으로 넘어감
        if (eggs[current].strength <= 0) {
            dfs(current + 1);
            return;
        }

        // 현재 계란으로 다른 계란을 타격 시도
        boolean anyEggHit = false;
        for (int i = 0; i < N; i++) {
            // 자기 자신이거나 이미 깨진 계란은 건너뜀
            if (i == current || eggs[i].strength <= 0) continue;

            // 계란 충돌
            anyEggHit = true;
            eggs[current].strength -= eggs[i].weight;
            eggs[i].strength -= eggs[current].weight;

            // 다음 계란으로 넘어가서 탐색
            dfs(current + 1);

            // 원상 복구 (백트래킹)
            eggs[current].strength += eggs[i].weight;
            eggs[i].strength += eggs[current].weight;
        }

        // 타격할 수 있는 계란이 없었다면 현재 계란을 건너뜀
        if (!anyEggHit) {
            dfs(current + 1);
        }
    }
}