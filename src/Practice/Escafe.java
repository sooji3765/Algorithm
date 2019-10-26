package Practice;

import java.util.Scanner;

public class Escafe {
    static int N,M;
    static char[][] map = new char[10][10];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Node Red,Blue,Hole;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.next().charAt(0);
                if (map[i][j]=='R') Red = new Node(i,j);
                if (map[i][j]=='B') Blue = new Node(i,j);
                if (map[i][j]=='O') Hole = new Node(i,j);
            }
        }

        int time = 0;
        while (time<=10){
            time++;

            for (int i=0;i<4;i++){
                int j = 1;
                while(j<N-2){
                    int rx = Red.x +dx[i]*j;
                    int ry = Red.y +dy[i]*j;

                    if (rx>=1&&rx<N-1&&ry>=1&&ry<N-1){
                        if (rx==Hole.x&&rx==Hole.y)
                            return;
                    }
                    j++;
                }
            }
        }

        System.out.println(time>10?-1:time);
    }
}
