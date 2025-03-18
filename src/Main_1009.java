import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-14
 * 풀이방법
 **/


public class Main_1009 {
    private static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i  < N ; i++ ){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(0L);
            long num = 1 ;
            long x = a%10 ;
            long startOneNum = x ;
            long count= 1;
            long answer =0;
            while(count<=b){
                num= num * a;
                x = num % 10;
                answer = x;

                arrayList.add(x);
                if(count==1)
                {
                    count++;
                    continue;
                }

                 if(startOneNum==x){
                     count--;
                    if(count ==0){
                        break;
                    }

                     long ss= b%(count);
                     int index = ss==0 ? (int)count:(int)ss;
                        answer= arrayList.get(index);

                     break;
                 }
                count++;

            }




            sb.append(answer % 10 ==0 ? 10: answer%10 ).append("\n");

        }
        System.out.println(sb.toString());
    }

}
