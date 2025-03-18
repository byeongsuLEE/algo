package day250316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-16
 * 풀이방법
 **/


public class Main_15953 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] oneContestPay;
    private static int[] twoContestPay;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        oneContestPay = new int [7] ;
        twoContestPay = new int [6] ;

        oneContestPay[1] = 5_000_000;
        oneContestPay[2] = 3_000_000;
        oneContestPay[3] = 2_000_000;
        oneContestPay[4] = 500_000;
        oneContestPay[5] = 300_000;
        oneContestPay[6] = 100_000;

        twoContestPay[1] = 5_120_000;
        twoContestPay[2] = 2_560_000;
        twoContestPay[3] = 1_280_000;
        twoContestPay[4] = 640_000;
        twoContestPay[5] = 320_000;


        for(int i = 1 ; i <=N; i++){
            st= new StringTokenizer(br.readLine());
            int rank1 = Integer.parseInt(st.nextToken());
            int rank2 = Integer.parseInt(st.nextToken());

            int rak1Index = 1;
            int sum1 = 1;
            while (sum1 < rank1){
                rak1Index++;
                sum1+=rak1Index;
            }

            int sum2 = 1;
            int rak2Index = 1;
            int multiNum =1 ;

            while(sum2<rank2){
                multiNum*=2;
                sum2+= multiNum;
                rak2Index++;
            }

            rak1Index = rak1Index > 6 || rank1==0 ? 0 :rak1Index;
            rak2Index = rak2Index > 5 || rank2 ==0 ? 0 :rak2Index;

            sb.append(oneContestPay[rak1Index] + twoContestPay[rak2Index]).append("\n");
        }
        System.out.println(sb.toString());




    }

}
