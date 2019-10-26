package Practice;

import java.util.LinkedList;
import java.util.Scanner;

public class Chicken {
    public static int N,M,Min=Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static LinkedList<Node> home = new LinkedList<>();
    static LinkedList<Node> store = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = System.currentTimeMillis();
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j]= sc.nextInt();
                if (map[i][j]==1) home.add(new Node(i,j));
                if (map[i][j]==2) store.add(new Node(i,j));
            }
        }
        visited = new boolean[store.size()];
        int[] arr = new int[M];
        dfs(0,arr);

        System.out.println(Min);
        long end = System.currentTimeMillis();
        System.out.println(end-s/1000.0);
    }

    public static void dfs(int index,int[] arr){

        if (index==M){
            int result =0;
            for (Node h : home){
                int min= Integer.MAX_VALUE;
                for (int i = 0; i < M; i++) {
                    //System.out.print(arr[i]+" ");
                    //int nx = h.x-store.get(arr[i]).x ;
                    //int ny = h.y-store.get(arr[i]).y ;
                    //int x = nx<0?nx*-1:nx;
                    //int y = ny<0?ny*-1:ny;
                    min=Math.min(min,Math.abs(h.x-store.get(arr[i]).x)+Math.abs(h.y-store.get(arr[i]).y));
                }

               result+=min;
            }

            Min = Math.min(Min,result);
            return;
        }else{
            for (int i = index; i < store.size(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    arr[index] = i;
                    dfs(index + 1, arr);
                    visited[i] = false;
                }
            }
        }
    }
}
