package day250325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-25
 * 풀이방법
 **/


public class Main_1476 {
    private static StringBuilder sb= new StringBuilder();
    private static int E,S,M;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        int count = 1;
        int se = 1;
        int ss = 1;
        int sm = 1;
        while(true){
            if(se == E && ss ==S  && sm ==M ){
                sb.append(count);
                break;
            }
            se = (se) % 15 +1;
            ss = (ss% 28)+1;
            sm = (sm % 19) +1;
            count++;
        }
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

    }
}
