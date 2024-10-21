package day1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int k = 0; k < n; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();  // 의상 이름은 필요없음
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);  // 의상 종류별로 개수를 저장
            }

            // 모든 의상 종류에 대해 입을 수 있는 경우의 수 계산
            int answer = 1;
            for (int value : map.values()) {
                answer *= (value + 1);  // 안 입는 경우 포함
            }

            sb.append(answer - 1).append("\n");  // 아무것도 안 입는 경우 제외
        }

        System.out.println(sb.toString());
    }
}
