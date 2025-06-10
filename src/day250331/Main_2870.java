package day250331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 작성자  : lbs
 * 날짜    : 2025-03-31
 * 풀이방법
 * "001"  str.replace("정규식", "" ) 앞에 있는 0을 "로 치환"
 **/


public class Main_2870 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static String inputStr;
    private static PriorityQueue<String> pq;

    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print(){

        while(!pq.isEmpty()){
            String str = pq.poll();
            sb.append(str).append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void solution() {
        int curContinueNumCount = 0;
        StringBuilder sbContinueNum = new StringBuilder();

        char beforeNum='.';
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            if(c>= '0'  && c <= '9'){ // 숫자일떄
                sbContinueNum.append(c);
                curContinueNumCount++;

            }else { // 문자일 때
                if(curContinueNumCount>=1){
                    String ltrim = sbContinueNum.toString().replaceFirst("^0+","");
                    ltrim = ltrim.equals("") ? "0" :ltrim;
                    pq.offer(ltrim);
                    curContinueNumCount=0;
                    sbContinueNum = new StringBuilder();
                }
            }
            beforeNum = c;
        }
        if(curContinueNumCount>=1){
            String ltrim = sbContinueNum.toString().replaceFirst("^0+","");
            ltrim = ltrim.equals("") ? "0" :ltrim;
            pq.offer(ltrim);
        }

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N =Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a,b)-> {
            if(a.length() == b.length()){
                return a.compareTo(b);
            }
            return a.length() -b.length();
        });
        for(int i =0 ; i < N ; i++){
            inputStr = br.readLine();
            solution();
        }

    }
}
