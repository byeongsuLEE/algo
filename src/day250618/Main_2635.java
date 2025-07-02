package day250618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-18
 * 풀이방법
 **/


public class Main_2635 {
    private static StringBuilder sb = new StringBuilder();
    private static int firstNum;
    private static int beforeLastNum;
    private static int lastNum;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {

        int beforeNum = firstNum;

        //재귀
        for (int i = 1; i <= beforeNum; i++) {
            dfs(i, 2, beforeNum);
        }

        sb.append(answer).append("\n");
        // 다시 복구
        ArrayList<Integer> arrayNum = new ArrayList<>();
        arrayNum.add(lastNum);
        arrayNum.add(beforeLastNum);

        for (int i = 2; i < answer; i++) {
            int frontValue = lastNum + beforeLastNum;
            arrayNum.add(frontValue);
            lastNum = beforeLastNum;
            beforeLastNum = frontValue;
        }

        for (int i = answer - 1; i >= 0; i--) {
            sb.append(arrayNum.get(i)).append(" ");
        }
    }


    private static void dfs(int num, int count, int beforeNum) {
        if (num < 0) {
            return;
        }
        if (answer < count) {
            answer = count;
            lastNum = num;
            beforeLastNum = beforeNum;
        }
        dfs(beforeNum - num, count + 1, num);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        firstNum = Integer.parseInt(br.readLine());
    }

}
