package day250116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935 {
    private static String str;      // 원본 문자열
    private static String bomb;     // 폭발 문자열
    private static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        init();       // 입력 초기화
        solution();   // 폭발 문자열 처리
    }

    // 🔸 입력 초기화 메서드
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();   // 원본 문자열 입력
        bomb = br.readLine();  // 폭발 문자열 입력
        stack = new Stack<>(); // 스택 초기화
    }

    // 🔸 폭발 문자열 처리 메서드
    private static void solution() {
        int bombLength = bomb.length();  // 폭발 문자열 길이

        for (char ch : str.toCharArray()) {
            stack.push(ch);  // 문자를 스택에 추가

            // 스택 크기가 폭발 문자열 길이 이상이면 비교
            if (stack.size() >= bombLength) {
                boolean isBomb = true;

                // 스택의 마지막 부분과 폭발 문자열 비교
                for (int i = 0; i < bombLength; i++) {
                    if (stack.get(stack.size() - bombLength + i) != bomb.charAt(i)) {
                        isBomb = false;
                        break;
                    }
                }

                // 폭발 문자열과 일치하면 스택에서 제거
                if (isBomb) {
                    for (int i = 0; i < bombLength; i++) {
                        stack.pop();
                    }
                }
            }
        }

        // 결과 출력
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char ch : stack) {
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
    }
}
