import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자   : user
 * 작성날짜 : 2024-07-22
 * 설명    :
 */
public class Main_6443 {
    private static StringBuilder sb;
    private static int N;
    private static char[] charArray;
    private static boolean[] selected;
    StringTokenizer st = null;
    static char []  selectedArray ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            charArray = (br.readLine()).toCharArray();
          selectedArray   = new char[charArray.length];
          Arrays.sort(selectedArray);
            selected = new boolean[charArray.length];
            permutation(0);
        }
        System.out.println(sb.toString());


    }


    private static void permutation(int cnt) {
        if(cnt  == charArray.length){
            for(int i  = 0 ; i< charArray.length ; i++){
                if(selected[i])
                    sb.append(selectedArray[i]);
            }
            sb.append("\n");
            return;

        }

        for(int i = 0 ; i < charArray.length; i++ ) {
            if(!selected[i]){
                selected[i] = true;
                selectedArray[cnt] = charArray[i];;
                permutation(cnt+1);
                selected[i]=false;

            }


        }

    }
}
