package day0715;

import java.io.IOException;
import java.util.Scanner;

/**
 * 작성자   : user
 * 작성날짜 : 2024-07-16
 * 설명    :
 */
public class Main_16719 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] orderNum ;
    public static int length ;
    private static boolean[] usedChar;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        StringBuilder sb = new StringBuilder() ;
        char[] charArray = inputString.toCharArray();
        usedChar = new boolean[charArray.length];
         orderNum = new int[charArray.length];
         length = charArray.length;
        int firstIndex = 101 ;

        for (int i  = 0 ; i < charArray.length ; i++ ) {
            orderNum[i] = charArray[i] - '0';

        }

        //앞을 어떻게 해야되는거임?



        //오른쪽
        dfs(0, charArray.length-1);

        System.out.println(sb.toString());
        //왼쪽


        // 0 2 1 5
        //0
        //01
        //02
        //1 2 3 4

        // B D E F G C A
        // 1 3 4 5 6 2 0


        // 6 0 5 1 2 3 4
        //

        // 3210
    }

    private static void dfs(int startIndex, int endIndex) {

        if(orderNum[startIndex] >orderNum[endIndex]){
            return;
        }

        int minIndex = startIndex;
        for(int i = startIndex ; i <=endIndex ; i++ ){
            if(orderNum[minIndex] < orderNum[startIndex]){
                minIndex = i;
            }

        }
        usedChar[minIndex] = true;

        for ( int i = 0 ; i < length ; i ++) {
            if (usedChar[i]) {
                sb.append((char) (orderNum[i] + '0'));
            }
        }
        sb.append("\n");

        dfs(minIndex+1,endIndex);
        dfs(startIndex,minIndex-1);

    }
}
