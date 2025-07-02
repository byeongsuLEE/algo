package day0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-25
 * 풀이방법
 **/


public class Main_14547 {
    private static StringBuilder sb= new StringBuilder();
    private static String input;

    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
        char[] charArray = input.toCharArray();
        int beforeNum =-1;
        int count =0;
        boolean checkedNum [] = new boolean [10];
        for(int i = 0 ; i < 4 ; i++){
            int num = charArray[i] - 48;
            if(beforeNum == num) {
                if(checkedNum[num]) continue;
                checkedNum[num] = true;
                if(count > 0 ) sb.append(" ").append("and ");
                sb.append(num).append(" ").append(num).append(" ").append("glued");
                count++;
            }
            beforeNum = num;
        }

       if( count == 0) return;

        sb.append("\n");
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("#")) break;
            input = st.nextToken();
            st.nextToken();
            solution();

        }
    }

}
