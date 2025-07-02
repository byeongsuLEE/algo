package day250630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-06-30
 * 풀이방법
 **/


public class Main_4999 {
    private static StringBuilder sb= new StringBuilder();
    private static String mySound;
    private static String requiredSound;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print(){
        System.out.println(sb.toString());
    }
    private static void solution() {
//        BiConsumer<String,String> consumer = (x, y) -> {
//            System.out.println(mySound.length() < requiredSound.length() ? "go" :"no");
//
//        };

        BiConsumer<String,String> consumer2 = Main_4999::isGotoHospital;
        consumer2.accept(mySound,requiredSound);
    }

    private static void isGotoHospital(String mySound, String requiredSound) {

        sb.append(mySound.length() >= requiredSound.length() ? "go" :"no");
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        mySound = br.readLine();
        requiredSound = br.readLine();
    }
}
