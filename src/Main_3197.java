import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-01
 * 풀이방법
 *
 * 오리 움직이기 (bfs)
 * 1. 기저 조건 : 오리 1 만 bfs 돌려서 'L'를 만나는 경우 종료
 * 2. NR , NC = 'X' 일 경우 다음 QUE에 저장한다.
 *
 * 얼음 꺠기 ( flood fill
 * 1. 맨처음  '.' 물들을 담는다.
 * 2. 담은 물 bfs 돌려서 깰 얼음들을 찾고 깬다 = 물로바꾼다.
 * 3. 물 바꾼다음에 그걸 다시 큐에 넣는다.
 * 2. 백조가 이동할 수 있는 범위를 넓혀가며 두 백조가 만나는 시점을 찾으면 종료.
 *
 **/


public class Main_3197 {
    private static int R, C;
    private static StringBuilder sb = new StringBuilder();
    private static char[][] map;
    private static boolean[][] visited;
    private static boolean[][][] checked;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[] sr = new int[2];
    private static int[] sc = new int[2];
    private static ArrayList<Location> StartArrayList;
    private static boolean[][] selected;
    private static int answer;
    private static Queue<Location> iceQueue = new ArrayDeque<>();
    private static boolean[][] visited2;
    private static ArrayDeque<Location> q;
    private static boolean[][] visitedIce;

    public static class Location {
        int r;
        int c;




        Location(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        while (true) {
            if (checkMeet()) break;
            brokenIce();
            answer++;

        }
        sb.append(answer);
        System.out.println(sb.toString());
    }


    private static boolean checkMeet() {
        ArrayDeque<Location> nextQue = new ArrayDeque<>();


        while(!q.isEmpty()){
            Location loc = q.poll();
            int r = loc.r;
            int c = loc.c;

            for(int d = 0 ; d < 4 ; d++){

                int nr = r+ dr[d];
                int nc = c+ dc[d];

                if( nr < 0 || nr >=R || nc < 0 || nc >=C ) continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc]=true;
                 if (map[nr][nc]=='L') return true;

               if(map[nr][nc] == '.'){
                   q.offer(new Location(nr,nc));
                }
               else if(map[nr][nc] == 'X')
                {
                    nextQue.offer(new Location(nr,nc));
                }
            }
        }



        q= nextQue;
        return false;
    }

        //기저 조건 : 공간에 대한 체크를 통해 해당 지점에 방문했는지 안했는지를 체크함



    private static void brokenIce () {

            int size = iceQueue.size();

            while (size-- > 0) {
                Location loc = iceQueue.poll();
                int r = loc.r;
                int c = loc.c;

                for (int d = 0; d < 4; d++) {
                    int nr = dr[d] + r;
                    int nc = dc[d] + c;

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != 'X') continue;
                    map[nr][nc] = '.';
                    iceQueue.offer(new Location(nr, nc));

                }
            }

        }
        private static void init () throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            visited = new boolean[R][C];
            visited2= new boolean[R][C];
            visitedIce = new boolean[R][C];;
            char[] input = null;
            int index = 0;
            for (int i = 0; i < R; i++) {
                Arrays.fill(map[i], '.');
            }

            for (int i = 0; i <R; i++) {
                input = br.readLine().toCharArray();
                for (int j =0; j < C; j++) {
                    char ch = input[j];
                    map[i][j] = ch;
                    if (map[i][j] == 'L') {
                        sr[index] = i;
                        sc[index] = j;

                        index++;
                    }


                    if (map[i][j] == '.' || map[i][j] =='L') {
                        iceQueue.offer(new Location(i, j));
                    }
                }

            }
            q = new ArrayDeque<>();
            q.offer(new Location(sr[0],sc[0]));
            visited[sr[0]][sc[0]] =true;




        }

}


