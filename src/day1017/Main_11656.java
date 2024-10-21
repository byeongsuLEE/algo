package day1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 작성자   : user
 * 작성날짜 : 2024-10-17
 * 설명    :
 */
public class Main_11656 {
    private static String str;

    public static void main(String[] args) throws IOException {

        init();
        Solution();
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

    }

    private static void Solution() {
        int length = str.length();
        char ch[] = str.toCharArray();


        //바로 아래 포문 두개를 람다식으로 못바꾸나?
         IntStream.range(0,length)
                .mapToObj(i -> str.substring(i)).sorted((a,b)->a.compareTo(b))
                .forEach(System.out::println);


        //1 번쨰 문제 : str를 stream으로 어떻게바꾸지??
        //->str은 stream으로 못바꾸고 array 나

    }
}
