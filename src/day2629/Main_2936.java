package day2629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2936 {
    private static StringBuilder sb = new StringBuilder();
    private static double x, y;
    private static final double HALF_AREA = 31250.0;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    private static void print() {
        System.out.println(sb.toString());
    }

    private static void solution() {
        if (x == 0 && y == 0) {
            sb.append("125.00 125.00");
        }
        else if (x > 0 && y > 0) {
            if (x > y) {
                sb.append(String.format("0.00 %.2f", 250.0 - HALF_AREA / x));
            } else {
                sb.append(String.format("%.2f 0.00", 250.0 - HALF_AREA / y));
            }
        }
        else if (y == 0) {
            if (x < 125) {
                double tmp = 250.0 - HALF_AREA / (250.0 - x);
                sb.append(String.format("%.2f %.2f", tmp, 250.0 - tmp));
            } else {
                sb.append(String.format("0.00 %.2f", HALF_AREA / x));
            }
        }
        else {
            if (y < 125) {
                double tmp = 250.0 - HALF_AREA / (250.0 - y);
                sb.append(String.format("%.2f %.2f", 250.0 - tmp, tmp));
            } else {
                sb.append(String.format("%.2f 0.00", HALF_AREA / y));
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
    }
}