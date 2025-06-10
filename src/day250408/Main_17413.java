package day250408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-08
 * 풀이방법
 * 1. 큐와 스택을 이용해보자.
 * - 큐는 < > 그대로 출력
 * - 스택은 거꾸로 출력하기 위해서 사용한다.
 * 2. 생각해보니 큐는 없애고 스택만 넣을 수 도 있을 듯 싶다.
 * 큐를 빼보자
 **/


public class Main_17413 {
    private static StringBuilder sb = new StringBuilder();
    private static String str;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {

        System.out.println(sb.toString());
    }

    private static void solution() {

        // < 가 나오면 > 가 나올 떄 까지 stack에 넣는다.
        // <아 아닌게 나오면 stack 에 넣는다.
        int index = 0;
        Stack<Character> stack = new Stack<>();
        while (index < str.length()) {
            if (str.charAt(index) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                while (str.charAt(index) != '>') {
                    sb.append(str.charAt(index));
                    index++;
                }
                sb.append(str.charAt(index)); // > 인것추가
            } else if (str.charAt(index) == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                sb.append(str.charAt(index));
            } else {
                stack.push(str.charAt(index));
            }

            index++;
        }
        //stack 에 남아있고 que에 안들어간 것들 넣어주기
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

    }
}
