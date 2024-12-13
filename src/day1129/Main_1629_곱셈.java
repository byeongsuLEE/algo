package day1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.X509Certificate;
import java.util.StringTokenizer;

/**
 * 작성자   : 이병수
 * 작성날짜 : 2024-11-29
 * 설명    :
 */
public class Main_1629_곱셈{
    private static long A;
    private static long C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        long B =  Long.parseLong(st.nextToken());
        C =  Long.parseLong(st.nextToken());


        // a^ b  % c =  a^(b/2) x a^ (b/2)


        System.out.println(div(B));

    }

    private static long div(long B ) {
        if (B == 0) {
            return 1;
        }
        //짝 수 일 떄
        long result = div(B/2) % C;
        if (B % 2 == 0) {

            return (result * result) % C;

        }
        //홀 수 일 떄
        else {
            return ((result * result % C) * (A % C)) % C;
        }
    }
}
