package day250324;

import java.io.*;
import java.util.*;

public class Main_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // 1m²당 참외 개수

        int[] dir = new int[6];
        int[] len = new int[6];

        int maxWidth = 0, maxHeight = 0;
        int maxWidthIdx = 0, maxHeightIdx = 0;

        // 입력
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());

            if ((dir[i] == 1 || dir[i] == 2) && len[i] > maxWidth) {
                maxWidth = len[i];
                maxWidthIdx = i;
            }
            if ((dir[i] == 3 || dir[i] == 4) && len[i] > maxHeight) {
                maxHeight = len[i];
                maxHeightIdx = i;
            }
        }

        // 작은 사각형 가로, 세로는 각각 큰 세로/가로의 양 옆에 있는 변의 길이
        int smallWidth = Math.abs(len[(maxHeightIdx + 5) % 6] - len[(maxHeightIdx + 1) % 6]);
        int smallHeight = Math.abs(len[(maxWidthIdx + 5) % 6] - len[(maxWidthIdx + 1) % 6]);

        int area = (maxWidth * maxHeight) - (smallWidth * smallHeight);
        System.out.println(area * K);
    }
}
