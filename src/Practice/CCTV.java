package Practice;

import java.util.LinkedList;
import java.util.Scanner;

public class CCTV {
    static int N,M;
    static int[][] map;

    static class Camera{
        int x;
        int y;
        int dir;

        public Camera(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static LinkedList<Camera> cameras = new LinkedList<>();
    static int[] dx = {-1,-0,1,0}; // 위 , 오, 아, 왼
    static int[] dy = {0,1,-0,-1};
    static int Min = Integer.MAX_VALUE;
    static int[] tern ={4,2,4,4,1};
    static int[][] dir = {
            {1,0,0,0},
            {1,0,1,0},
            {1,1,0,0},
            {1,1,1,0},
            {1,1,1,1}
    };
    // 1: 4번, 2 : 2번, 3: 4번, 4 : 4번, 5 : 1번

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j]>=1&&map[i][j]<=5) cameras.add(new Camera(i, j, map[i][j]));
            }
        }
        dfs(0, cameras.size());
        System.out.println(Min);
    }
    public static void watch(int x,int y,int dir){
        int sr = x;
        int sc = y;

        for (;;){
            int nx = sr+dx[dir];
            int ny = sc+dy[dir];

            if (nx<0||nx>=N||ny<0||ny>=M) return;
            if (map[nx][ny]==6) return;
            map[nx][ny] = 7;
            sr=nx; sc=ny;
        }

    }
    public static void dfs(int index, int count){

        if (index==count){
            int sum = 0;
            for (int i=0;i<N;i++){
                for (int j = 0; j < M; j++) {
                    if (map[i][j]==0) sum++;
                }
            }
            //print(map);
            Min = Math.min(Min,sum);
            return;
        }else{
            int[][] back = new int[N][M];
            Camera c = cameras.get(index);
            for (int i = 0; i < tern[c.dir-1] ; i++) {
                copymap(back,map);
                for (int j = 0; j < 4; j++) {
                    if (dir[c.dir-1][j]==1)
                        watch(c.x,c.y,(i+j)%4);
                }
                dfs(index+1,count);
                copymap(map,back);
            }
        }

    }

    public static void copymap(int[][] copy, int[][] origin){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = origin[i][j];
            }
        }
    }

    public static void print(int[][] maps){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(maps[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }
}
