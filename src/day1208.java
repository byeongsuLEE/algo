import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class day1208 {
    public static boolean[] selected;
    public static Set<List<Integer>> selectedList;
    public static int[] selectedNum;
    private static List<Integer> numbers;

    private static StringBuilder sb =new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        selected = new boolean[N];
        selectedList = new LinkedHashSet<>();
        selectedNum = new int[M];
        numbers = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numbers);

        numbers = numbers.stream().distinct().collect(Collectors.toList());

        permutation(0,0, M, N);


        System.out.println(sb.toString());
    }

    private static void permutation(int cnt,int start, int M, int N) {
        if (cnt == M) {

            Arrays.stream(selectedNum).forEach(a -> sb.append(a + " "));
            sb.append("\n");


            return;
        }
        for (int i = 0; i < numbers.size(); i++) {

            if (cnt  > 0 &&  selectedNum[cnt-1] <= numbers.get(i)) {

                selectedNum[cnt] = numbers.get(i);
                permutation(cnt + 1,start+1, M, N);

            }else if(cnt==0){
                selectedNum[cnt] = numbers.get(i);
                permutation(cnt + 1,start+1, M, N);
            }

        }
    }
}
