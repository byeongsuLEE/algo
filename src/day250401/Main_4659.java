package day250401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-04-01
 * 풀이방법
 * 재귀로 연속된 수 카운트를 간단하게 구현할 수 있을 꺼라 생각해서 재귀 사용
 **/


public class Main_4659 {
    private static StringBuilder sb= new StringBuilder();
    private static String str;

    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        boolean isGoodPassword =  checkGoodPassword(0,0,0,'.',false);

        sb.append("<").append(str).append(">");
        if(isGoodPassword){
            sb.append(" is acceptable.");
        }else{
            sb.append(" is not acceptable.");
        }
        sb.append("\n");

    }

    private static boolean checkGoodPassword(int curIndex , int aeiouContinueCount, int jaumContinueCount, char beforePassword, boolean isIncludeAEIOU) {





        if(curIndex == str.length()){
            if(isIncludeAEIOU){
                return true;
            }
            return false;
        }






            char curChar = str.charAt(curIndex);
            if(curChar == 'a' || curChar == 'e' || curChar == 'i' || curChar == 'o' || curChar == 'u'){
                isIncludeAEIOU = true;
                aeiouContinueCount++;
                jaumContinueCount=0;
            }else {
                jaumContinueCount++;
                aeiouContinueCount=0;
            }
            if(jaumContinueCount >=3 || aeiouContinueCount >=3){
               return false;
            }

            if(beforePassword==curChar){
                if(!(curChar=='e' || curChar == 'o')){
                    return false;
                }
            }
            beforePassword = curChar;



        return checkGoodPassword(curIndex+1,aeiouContinueCount,jaumContinueCount,beforePassword,isIncludeAEIOU);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(!((str=br.readLine()).equals("end"))){
            solution();
        }
    }

}
