package day250321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-21
 * 풀이방법
 **/


public class Main_9037 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] candy;

    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        int culCount = 0;
        while(!isSameValue()){
            // 짝수로 만들기
            int nextAddNum = 0 ;
            int beforeNum =candy[N]/2;
            for(int i = 1 ; i <=N ; i++){

                nextAddNum =candy[i]/2;
                candy[i]/=2;
                candy[i] +=beforeNum;
                if(candy[i] % 2 !=0) candy[i]+=1;
                beforeNum=nextAddNum;
            }


            culCount++;
        }
        sb.append(culCount).append("\n");


    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t<= T ; t++){
            N= Integer.parseInt(br.readLine()); // 아이의 인원
            candy = new int[N+1];
            st=new StringTokenizer(br.readLine());
            for(int i = 1 ; i <=N ; i++){
                candy[i] = Integer.parseInt(st.nextToken());
                //초기 짝수로 만들어주기
                if(candy[i] % 2 !=0) candy[i]+=1;
            }

            solution();

        }

    }

    public static boolean isSameValue() {
        int firstValue =candy[1];
        boolean isSameValue =true;
        for(int i = 2; i<=N; i++){
            if(firstValue!= candy[i]) {
                isSameValue = false;
                break;
            }
        }
        return isSameValue ;
    }

}
