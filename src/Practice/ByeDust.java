package Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ByeDust {
    static int R,C,T;
    static int[][] map;
    static class Dust{
        int x,y,d;
        public Dust(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static Node[] cleans = new Node[2];
    static Queue<Dust> dusts = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        map = new int[R][C];

        // input
        int index=0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j]>0)
                    dusts.offer(new Dust(i,j,map[i][j]));
                if (map[i][j]==-1){
                    cleans[index++]= new Node(i,j);
                }
            }
        }

        for (int t=0;t<T;t++){

            int[][] arr = new int[R][C];
            // 미세먼지 확산
            while (!dusts.isEmpty()){
                Dust dust = dusts.poll();
                int spread = dust.d/5;
                int cnt=0;

                for (int i=0;i<4;i++){
                    int nx = dust.x+dx[i];
                    int ny = dust.y+dy[i];

                    if (nx<0||nx>=R||ny<0||ny>=C) continue;
                    if (map[nx][ny]==-1) continue;

                    arr[nx][ny]+=spread;
                    cnt++;
                }


                int rest = spread*cnt;

                arr[dust.x][dust.y]-=rest;

            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j]+=arr[i][j];
                }
            }


            // 공기 청소기 순환
            // first
            Node clean = cleans[0];
            int cx = clean.x;
            int cy = clean.y;

            for (int i = cx-2; i >=0 ; i--) {
                map[i+1][0] = map[i][0];
            }

            for (int i = 1; i<C ; i++) {
                map[0][i-1] = map[0][i];
            }

            for (int i = 1; i <= cx; i++) {
                map[i-1][C-1]=map[i][C-1];
            }

            for (int i = C-2; i >=1 ; i--) {
                map[cx][i+1]=map[cx][i];
            }

            map[cx][1]=0;

            //second
            clean = cleans[1];
            cx = clean.x;
            cy = clean.y;

            for (int i = cx+2; i<R ; i++) {
                map[i-1][0]=map[i][0];
            }
            for (int i = 1; i<C ; i++) {
                map[R-1][i-1]=map[R-1][i];
            }
            for (int i = R-2; i>=cx ; i--) {
                map[i+1][C-1]=map[i][C-1];
            }
            for (int i = C-2; i>=0 ; i--) {
                map[cx][i+1]=map[cx][i];
            }

            map[cx][1]=0;

            countDust();
        }


        System.out.println(count());
    }

    static int count(){
        int count=0;
        for (int i = 0; i <R ; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j]>0)
                count+=map[i][j];
            }
        }
        return count;
    }

    static void countDust(){

        for (int i = 0; i < R; i++) {
            for (int j = 0; j <C ; j++) {
                if (map[i][j]>0){
                    dusts.offer(new Dust(i,j,map[i][j]));
                }
            }
        }
    }

    static void print(int[][] map){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j <C ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("==============================");
    }
}
