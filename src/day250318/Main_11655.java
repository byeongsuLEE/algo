package day250318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-18
 * 풀이방법
 **/


public class Main_11655 {
    private static StringBuilder sb= new StringBuilder();
    private static String str;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        for(int i = 0 ; i <str.length(); i++ ){
            char ch = str.charAt(i);


            if(ch>='a' && ch <='z'){ // 소문자
                 ch = (char) ((ch-'a' +13) % 26 + 'a');
            }
            else if(ch >= 'A' && ch <='Z'){ //대문자
                ch = (char) ( (ch-'A'+13) % 26 +'A');
            }
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str= br.readLine();
    }

}
