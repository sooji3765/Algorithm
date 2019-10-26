package Practice;

import java.util.Scanner;

public class Fish {
    static int R,C,M,SIZE=0;
    static class Sharck{
        int s,d,z;
        public Sharck( int s, int d,int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }

    }
    static int[][] dxy = {{-1,0},{1,0},{0,1},{0,-1}}; // 위 아래 오른 왼  0 1 2 3

    static Sharck[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();
        map = new Sharck[R][C];
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();

            map[r-1][c-1] = new Sharck(s,d-1,z);
        }


        //이동
        for (int i=0;i<C;i++){
            for(int k =0;k<R;k++){
                if(map[k][i]!=null){
                    SIZE+=map[k][i].z;
                    map[k][i] = null;
                    break;
                }
            }

            Sharck[][] arr = new Sharck[R][C];

            // 상어 이동
            for (int r=0;r<R;r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] != null) {
                        Sharck sharck = map[r][c];
                        int dir = sharck.d;
                        int speed = sharck.s;
                        int x=r,y=c;

                        while (speed>=1){
                            x+=dxy[dir][0];
                            y+=dxy[dir][1];

                            if (x<0||x>=R||y<0||y>=C){
                                x-=dxy[dir][0];
                                y-=dxy[dir][1];
                                if(dir==0)
                                    dir=1;
                                else if(dir==1)
                                    dir=0;
                                else if(dir==2)
                                    dir=3;
                                else if(dir==3)
                                    dir=2;
                                continue;
                            }
                            speed--;
                        }
                        sharck.d = dir;
                        if ((arr[x][y] == null) || (arr[x][y] != null && arr[x][y].z < sharck.z))
                            arr[x][y] = sharck;
                    }
                }

            }
            copyMap(map,arr);

        }

        System.out.println(SIZE);
    }

    static void copyMap(Sharck[][] copy, Sharck[][] origin){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
               copy[i][j]= origin[i][j];
            }
        }
    }

}
