package day250305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자  : 이병수
 * 날짜    : 2025-03-05
 * 풀이방법
 * 트리의 순회
 *  postOrder 마지막 의 인덱스는 항상 root임
 *  inorder 에서 root를 기준으로 왼쪽과 오른쪽은 두 가지로 나눌 수 있음
 *  inorder를 기준으로 왼쪽 노드 개수와 오른쪽 노드 개수를 구할 수 있음
 *  preorder를 기준으로 봤을떄
 *  왼쪽 서브쿼리 :  왼쪽 index는 그대로 postStart  오른쪽 index = postStart + 왼쪽노드의 개수(leftTreeCount)-1
 *  오른쪽 서브쿼리: 왼쪽 인덱스는 postStart + leftTreeCount , 오른쪽 인덱스는 end-1
 **/


public class Main_2263 {
    private static StringBuilder sb= new StringBuilder();
    private static int N;
    private static int[] inOrder , postOrder,rootIndex;

    public static class Node{
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {


        dfs(0,N-1,0,N-1);
        System.out.println(sb.toString());



    }

    // post 의 인덱스는 항상 root임
    // inorder의 왼쪽 오른쪽은 서브쿼리와 오른쪽서브쿼리로 나눌수잇음
    // prorder의 0 부터 x까지는 왼쪽서비쿼리르의 개수 +  x+1 ~ n-1까지는 오른쪽 서브쿼리의 개수임
    private static void dfs(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart  > inEnd || postStart > postEnd  ) {
            return;
        }

        int root = postOrder[postEnd];
        sb.append(root).append(" ");
        int index = rootIndex[root];
        int leftTreeCount = index  -inStart;
        int rightTreeCount = inEnd - index;

        //왼쪽
        dfs(inStart,index-1,postStart,postStart + leftTreeCount - 1 );
        //오른쪽 서브쿼리
        dfs(index+1,inEnd,postStart + leftTreeCount, postEnd-1);

    }




    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        StringTokenizer st1= new StringTokenizer(br.readLine());
        inOrder = new int[N];
        postOrder = new int[N];
        rootIndex = new int[100_001];

        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            rootIndex[inOrder[i]]=i;
            postOrder[i] = Integer.parseInt(st1.nextToken());
        }






    }
}
