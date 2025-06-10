package day250327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 작성자  : lb
 * 날짜    : 2025-03-27
 * 풀이방법
 **/


public class Main_2621 {
    private static StringBuilder sb = new StringBuilder();
    private static char[] inputChar;
    private static int[] inputCountNum;
    private static HashMap<Character, Integer> charCountMap;
    private static Card[] cardList;
    private static int AllhighNum;
    private static int sameNumMaxCount;
    private static int sameNum;
    private static HashMap<Integer, Integer> sameNumMap;

    public static class Card implements Comparable<Card> {
        int num;
        char ch;

        public Card(int num, char ch) {
            this.num = num;
            this.ch = ch;
        }

        @Override
        public int compareTo(Card o) {
            return Integer.compare(num, o.num);
        }

    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {
        Arrays.sort(cardList);
        boolean isContinueNum = isContinueNum();
        int answer = 0;
        if (isContinueNum && charCountMap.size() == 1) {
            answer = AllhighNum + 900;
        } else if (sameNumMaxCount == 4) {
            answer = sameNum + 800;
        } else if (sameNumMaxCount == 3 && sameNumMap.size() == 2) {
            for (Integer num : sameNumMap.keySet()) {
                int numCount = sameNumMap.get(num);
                if (numCount == 3) {
                    answer += (num * 10);
                } else if (numCount == 2) {
                    answer += (num + 700);
                }
            }

        } else if (charCountMap.size() == 1) {
            answer = AllhighNum + 600;
        } else if (isContinueNum) {
            answer = AllhighNum + 500;

        } else if (sameNumMaxCount == 3) {
            answer = sameNum + 400;
        } else if (sameNumMaxCount == 2 && sameNumMap.size() == 2) {
            int maxNum = -1;
            int minNum = 10;
            for (Integer num : sameNumMap.keySet()) {
                minNum = Math.min(minNum, num);
                maxNum = Math.max(maxNum, num);
            }
            answer += (maxNum * 10);
            answer += (minNum + 300);

        } else if (sameNumMaxCount == 2 && sameNumMap.size() == 1) {
            answer = sameNum + 200;
        } else {
            answer = AllhighNum + 100;
        }
        sb.append(answer);

    }

    private static boolean isContinueNum() {
        boolean isContinueNum = true;
        int firstDiff = cardList[1].num - cardList[0].num;
        for (int i = 1; i < 4; i++) {
            if (cardList[i].num + firstDiff != cardList[i + 1].num) {
                isContinueNum = false;
                break;
            }
        }
        return isContinueNum;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        inputCountNum = new int[10];
        inputChar = new char[5];
        cardList = new Card[5];
        charCountMap = new HashMap<>();
        sameNumMap = new HashMap<>();
        AllhighNum = 0;
        sameNumMaxCount = 0;
        sameNum = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            cardList[i] = new Card(num, ch);
            inputCountNum[num]++;

            if (inputCountNum[num] > 1) {
                sameNumMap.put(num, inputCountNum[num]);
                sameNum = num;
                sameNumMaxCount = Math.max(sameNumMaxCount, inputCountNum[num]);
            }


            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);

            AllhighNum = Math.max(AllhighNum, num);
        }


    }
}
