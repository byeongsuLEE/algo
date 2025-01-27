package day250121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1062 {
    private static int N;
    private static int K;
    private static int answer;
    private static ArrayList<Character> allCanSelectCh;
    private static List<Set<Character>> allSet;

    public static void main(String[] args) throws IOException {
        init(); // 입력 처리
        solution(); // 문제 해결
        print(); // 결과 출력
    }

    private static void solution() {
        if (K < 5) { // 최소 5개의 알파벳이 필요
            answer = 0;
            return;
        }

        if (K == 26) { // 모든 알파벳을 가르칠 수 있는 경우
            answer = N;
            return;
        }

        if (K - 5 >= allCanSelectCh.size()) { // 선택 가능한 알파벳이 모두 포함될 수 있는 경우
            answer = N;
            return;
        }

        Set<Character> selectChSet = new HashSet<>();
        combination(selectChSet, K - 5, 0); // 필수 알파벳 제외한 K-5개 선택
    }

    private static void combination(Set<Character> selectedSet, int cnt, int start) {
        if (cnt == 0) {
            int canReadCount = 0;
            for (Set<Character> wordSet : allSet) {
                if (selectedSet.containsAll(wordSet)) {
                    canReadCount++;
                }
            }
            answer = Math.max(answer, canReadCount);
            return;
        }

        for (int i = start; i < allCanSelectCh.size(); i++) {
            selectedSet.add(allCanSelectCh.get(i)); // 현재 문자 선택
            combination(selectedSet, cnt - 1, i + 1); // 다음 문자 선택
            selectedSet.remove(allCanSelectCh.get(i)); // 선택 해제 (백트래킹)
        }
    }

    private static void print() {
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = 0;
        allSet = new ArrayList<>();
        Set<Character> tempSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Set<Character> characters = new HashSet<>();

            for (int k = 4; k < str.length() - 4; k++) { // "anta"와 "tica" 제외한 문자만 처리
                char c = str.charAt(k);
                if (c != 'a' && c != 'n' && c != 't' && c != 'i' && c != 'c') { // 필수 문자 제외
                    characters.add(c);
                    tempSet.add(c);
                }
            }

            allSet.add(characters); // 단어별 필요한 문자 집합 추가
        }

        allCanSelectCh = new ArrayList<>(tempSet); // 중복 제거된 문자 리스트 생성
    }
}
