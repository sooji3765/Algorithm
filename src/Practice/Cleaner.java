package Practice;

import java.util.Scanner;

public class Cleaner {
    static int N,M,cnt=0;
    static int[][] map;
    static class Robot{
        int x,y,dir;
        public Robot(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static int[][] dxy = {{-1,0},{0,1},{1,0},{0,-1}}; //0 북 1 동 2 남 3 서
    static Robot robot ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        int x = sc.nextInt();
        int y = sc.nextInt();
        int dir = sc.nextInt();

        robot = new Robot(x,y,dir);

        for (int i = 0; i <N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        solve();
        System.out.println(cnt);

    }

    public static void solve(){

        for (;;){
            // 1. 현재 위치 청소
            if(map[robot.x][robot.y]==0) {
                map[robot.x][robot.y] = 2;
                cnt++;

            }
            // 2. 왼쪽 방향으로 탐색

            int next = robot.dir-1<0?3:robot.dir-1;
            int cntd = 0;
            int nx = robot.x + dxy[next][0];
            int ny = robot.y + dxy[next][1];

            while(cntd<=4) {

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                if (cntd == 4){
                    int change = 0;
                    switch (robot.dir){
                        case 0 : change=2; break;
                        case 1 : change=3; break;
                        case 2 : change=0; break;
                        case 3 : change=1; break;
                    }
                    int a = robot.x+dxy[change][0];
                    int b = robot.y+dxy[change][1];
                    if (check(a,b)){
                        robot.x = a;
                        robot.y = b;
                        break;
                    }else{
                        return ;
                    }
                }
                if (map[nx][ny] == 0) {
                    robot.x = nx;
                    robot.y = ny;
                    robot.dir = next;
                    break;
                } else {
                    robot.dir = next;
                    next = next-1<0?3:next-1;
                    nx = robot.x + dxy[next][0];
                    ny = robot.y + dxy[next][1];
                    cntd++;
                }
            }
        }
    }

    public static boolean check(int a, int b){
        if (a<0||a>=N||b<0||b>=M) return false;
        if (map[a][b]==1) return false;
        return true;
    }
}
