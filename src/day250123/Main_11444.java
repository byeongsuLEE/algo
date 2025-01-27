package day250123;

import java.util.Scanner;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-01-23
 * 풀이방법
 * 피사노 주기 = 피보나치 수열을 어떤 M 으로 나눈 나머지 값들이 반복되기 시작하는 주기의 길이
 * P(피사노 주기 = 주기의 길이 ) =  15 * 10(k-1)
 * P = Mod /10 * 15;
 *
 *
 *
 * 10c=7
 * N % P  % M
 *
 **/


public class Main_11444 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
//        double K = Math.log10( 10000000007L);
        int mod = 1000000007;
        int P = (mod/10 * 15);





        long one = 0;
        long two = 1;

        for(int i =2 ; i <=(N % P); i++){
            long next = (one % mod + two ) % mod;
            one = two;
            two = next;
        }

        if(N ==1 ){
            System.out.println(1);
            return;
        }

        System.out.println(two);

    }

}
