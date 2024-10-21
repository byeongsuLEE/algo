package day1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자   : user
 * 작성날짜 : 2024-10-18
 * 설명    :
 */
public class Main_28702 {
    private static String[] str;
    private static int lastNum;

    public static void main(String[] args) throws IOException {
        init();
        Solution();



    }

    private static void Solution() {
        String answer = changeFizzBuzz();
        System.out.println(answer);
    }

    private static String changeFizzBuzz() {
        if( lastNum % 3 == 0 && lastNum % 5 == 0 ) {
            return "FizzBuzz";
        }
        else if( lastNum % 3 == 0  & lastNum % 5 != 0 ) {
            return "Fizz";

        }
        else if( lastNum % 5 == 0 && lastNum % 3 != 0 ) {
            return "Buzz";
        }
        else{
            return String.valueOf(lastNum);
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str= new String[3];

         lastNum = 0;
        for(int i = 0 ; i < 3 ; i ++){
            str[i] = br.readLine();
            if(isNum(str[i])){
                 lastNum = Integer.parseInt(str[i]) +3-i;
            }
        }
    }

    private static boolean isNum(String s) {
        if(s.equals("Fizz") || s.equals("Buzz") || s.equals("FizzBuzz")){
            return false;
        }
        return true;
    }
}
