package day250315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-15
 * 풀이방법
 **/


public class Main_10942 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] numbers;
    private static int M;
    private static int[][] isPalindrom;

    public static void main(String[] args) throws IOException {
        initSolution();
    }

    private static void solution2() {
        for(int i = 1 ; i<=N ;i++){
            for(int j = i ; j<=N; j++){
                if(i==j){
                    isPalindrom[i][j] = 1;
                    continue;
                }

                int a = i;
                int b = j;

                int answer = 1;
                while(a<b){
                    if(isPalindrom[a][b]!=-1){
                        answer = isPalindrom[a][b];
                        break;
                    }

                    if(numbers[a] != numbers[b]) {
                        answer = 0;
                        break;
                    }
                    else{
                        a++;
                        b--;
                    }


                }
                isPalindrom[i][j]= answer;

            }
        }

    }

//    private static int solution(int a, int b) {
//
//        while(a<b){
//            if(isPalindrom[a][b]!=-1){
//                answer = isPalindrom[a][b];
//                break;
//            }
//
//            if(numbers[a] != numbers[b]) {
//                answer = 0;
//                break;
//            }
//            else{
//                a++;
//                b--;
//            }
//
//
//        }
//
//        isPalindrom[a][b]=answer;
//        return isPalindrom[a][b];
//    }

    private static void initSolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        numbers= new int[N+1];
        isPalindrom = new int [N+1][N+1];
        for(int i = 0 ; i < N+1; i++){
            Arrays.fill(isPalindrom[i],-1);
        }
        st= new StringTokenizer(br.readLine());
        for(int i = 1 ; i <=N ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        solution2();
        for(int i = 0 ; i < M ; i++){
            int answer = 0;
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());



            sb.append(isPalindrom[a][b]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
