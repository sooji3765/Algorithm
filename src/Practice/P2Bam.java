package Practice;

import java.util.LinkedList;
import java.util.Scanner;

public class P2Bam {
    static int N, K, L;
    static class Move{
        int time;
        String dir;

        public Move(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }
    static class Node{
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static int[][] dxy = {{-1,0},{0,1},{1,0},{0,-1}};
    static LinkedList<Node> snack = new LinkedList<>();
    static LinkedList<Move> moves = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        // 뱀 스타트;
        snack.add(new Node(0,0));
        K = sc.nextInt();
        for (int i=0;i<K;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 사과
            map[x-1][y-1] = 1;
        }

        L = sc.nextInt();

        for (int i=0;i<L;i++) {
            int time = sc.nextInt();
            String dir = sc.nextLine().trim();
            moves.add(new Move(time,dir));
        }

        int result = solve();
        System.out.println(result);
    }
    public static int solve(){
        int time=0;
        boolean ischeck = true;

        int len = 1; // 뱀 길이
        int m = 0 ;// move 제어
        int dir = 1; // 방향 제어
        while (ischeck){

            time++;
            print(time);
            int ldx = snack.size()-1;
            Node sn = snack.get(ldx);

            int nx = sn.x+dxy[dir][0];
            int ny = sn.y+dxy[dir][1];

            // 벽에 부딪치는 것
            if (nx<0||nx>=N||ny<0||ny>=N) break;

            // 자기 몸에 부딫치는 것
            for (Node n : snack){
                if (n.x==nx&&n.y==ny){
                    ischeck = false;
                    break;

                }
            }

            // 사과가 있으면
            if (map[nx][ny]==1){
                len++;
                map[nx][ny]=0;
                snack.add(new Node(nx,ny));
            }else{
                snack.remove(0);
                snack.add(new Node(nx,ny));
            }

            if(m<L){
                if (moves.get(m).time == time){
                    String mm = moves.get(m).dir;
                    if (mm.equals("L")){
                        dir=dir-1<0?3:dir-1;
                    }else{
                        dir=dir+1>3?0:dir+1;
                    }
                    m++;
                }
            }
        }
        return time;
    }
    public static void print(int t){
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                copy[i][j]= map[i][j];
            }
        }

        for (Node n : snack){
            copy[n.x][n.y] =2;
        }

        System.out.println("====시간 :"+t+"===============");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
    }
}
