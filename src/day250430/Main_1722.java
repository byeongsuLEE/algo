package day250430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-30
 * 풀이방법
 **/


public class Main_1722 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int num;
    private static int[] input;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solutionB() {

        //i 는 자리수
        int count = 0;
        for(int i  = 0 ; i < N ; i++){
            for(int j = 0 ; j < input[i]-1 ; j++){
                if (visited[j]) continue;
                count+= factorial(N-i-1);
            }
            visited[input[i]-1]=true;

        }
        sb.append(count+1);
    }

    private static void solutionA() {
        factorial(N);
        int count = N ;
        int index =0;
        while (count >= 1){
            int factorial = factorial(--count);
            int inputIndex = (num-1)/factorial;
            int count1=0;
            for(int  i = 0 ; i < N ; i++){
                if(visited[i]) continue;
                if(inputIndex==count1){
                    visited[i] = true;
                    num = num - (inputIndex * factorial ) ;
                    sb.append(input[i]).append(" ");
                    break;
                }else{
                    count1++;
                }
            }


        }
    }

    private static int factorial(int n) {
        if(n<=1){
            return 1;
        }

        return n*factorial(n-1);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        st= new StringTokenizer(br.readLine());
        int problemNum = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        if(problemNum == 1){
            num = Integer.parseInt(st.nextToken());
            input = new int[N];
            for(int i=0;i<N;i++){
                input[i] = i+1;
            }
            solutionA();
        }else{
            input = new int[N];
            for(int i = 0 ; i < N ; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            solutionB();
        }
    }


}
