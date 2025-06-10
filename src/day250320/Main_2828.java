package day250320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-20
 * 풀이방법
 **/


public class Main_2828 {
    private static StringBuilder sb= new StringBuilder();
    private static int N,M;
    private static int J;
    private static int[] appleLocation;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        int curIndex = 1;
        int boxIndex = curIndex+ M - 1;

        int moveCount  =0 ;
        for(int appleIndex = 1 ; appleIndex <=J ; appleIndex++){
            int appleFallIndex = appleLocation[appleIndex];

            // 움직이지 않고 담을 수 있다면
            if(appleFallIndex >=curIndex && appleFallIndex <=boxIndex) {
                continue;
            }else if(appleFallIndex < curIndex){ // 움직여야지만 담을 수 있따면
                // 왼쪽에 있을 경우
                int distance = curIndex- appleFallIndex;
                curIndex-=distance;
                moveCount+=distance;

            }else{
                int distance = appleFallIndex- boxIndex;
                curIndex+=distance;
                moveCount+=distance;
            }

            boxIndex = curIndex+ M - 1;
        }
        sb.append(moveCount);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        J = Integer.parseInt(br.readLine());

        appleLocation = new int [J+1];

        for(int appleIndex = 1 ; appleIndex <= J ; appleIndex++){
            appleLocation[appleIndex] = Integer.parseInt(br.readLine());
        }

    }
}
