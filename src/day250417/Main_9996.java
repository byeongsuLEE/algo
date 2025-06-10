package day250417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-17
 * 풀이방법
 **/


public class Main_9996 {
    private static StringBuilder sb= new StringBuilder();
    private static String pattern;
    private static String str;
    private static int index;

    public static void main(String[] args) throws IOException {
        initSolution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {

        // *의 왼쪽은 str 앞쪽부터 pattern 앞쪽부터 순차 비교
        for(int i = 0 ;  i < index ; i++){
            if(pattern.charAt(i)!=str.charAt(i)){
                sb.append("NE").append("\n");
                return;
            }
        }


        // * 오른쪽은 for(int i= str.size()-1 ;
        // pattern의 맨오른쪽부터 index+1까지
        // 문자열의 마지막과 비교
        for(int i = pattern.length()-1 ; i > index ; i--){

            int strLastIndex = str.length()+ i-pattern.length();
            if(pattern.charAt(i)!=str.charAt(strLastIndex)){
                sb.append("NE").append("\n");
                return;
            }
        }

        if(str.length() < pattern.length()-1){
            sb.append("NE").append("\n");
            return;
        }

        sb.append("DA").append("\n");

    }

    private static void initSolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        pattern = br.readLine();
        index = pattern.indexOf('*');

        for( int t = 0; t < T; t++){
            str =br.readLine();
            solution();
        }
    }
}
