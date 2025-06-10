package day250403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 작성자  : lb
 * 날짜    : 2025-04-03
 * 풀이방법
 **/


public class Main_3986 {
    private static StringBuilder sb= new StringBuilder();
    private static String str;
    private static int count =0;
    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print(){
        sb.append(count);
        System.out.println(sb.toString());
    }
    private static void solution() {

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);

            if(stack.isEmpty()){
                stack.push(ch);
            }else if(stack.peek() == ch){
                stack.pop();
            } else{
                stack.push(ch);
            }

        }
        if( stack.isEmpty() ){
            count++;
        }

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            str = br.readLine();
            solution();
        }
    }
}
