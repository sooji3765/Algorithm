package Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P4Searching {
    static int N, M, Min=1000;
    static String[][] map;
    static String[][] temp;
    static boolean[][] visited;
    static class Node{
        int x;
        int y;
        int value;
        public Node(int x, int y,int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static int[] dx = {-1,0,1,0}; // 아래, 위, 왼, 오
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N= sc.nextInt();
        M = sc.nextInt();

        map = new String[N][N];
        temp =new String[N][N];

        for (int i =0;i<N ;i++){
            for (int j =0;j<N;j++){
                int input = sc.nextInt();
                switch (input) {
                    case 2 :
                        map[i][j] = "*";
                        break;
                    case 1 :
                        map[i][j] ="-";
                        break;
                    default:
                        map[i][j] ="x";
                        break;
                }
            }
        }

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("*")){
                    copyMap(temp,map);
                    temp[i][j]="0";
                    makeVirus(1);
                    temp[i][j]="*";
                }
            }
        }

        System.out.println(Min==1000?-1:Min);
    }

    private static void makeVirus(int count) {
        if (count==M){
            spread();

            return;
        }
        for (int i=0;i<N;i++){
            for (int j = 0; j < N ; j++) {
                if (temp[i][j].equals("*")){
                    temp[i][j]="0";
                    makeVirus(count+1);
                    temp[i][j]="*";
                }
            }
        }
    }

    private static void spread() {
        String[][] arr = new String[N][N];
        visited=new boolean[N][N];
        copyMap(arr,temp);
        Queue<Node> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j].equals("0"))
                    list.offer(new Node(i,j,0));
            }
        }

        while (!list.isEmpty()){
            Node v = list.poll();
            int x = v.x;
            int y = v.y;
            int value = v.value;

            for (int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if (nx>=0&&nx<N&&ny>=0&&ny<N){
                    if ((arr[nx][ny].equals("x")||arr[nx][ny].equals("*"))&&!visited[nx][ny]){

                        visited[nx][ny] = true;
                        arr[nx][ny] = (value+1)+"";
                        list.offer(new Node(nx, ny,value+1));
                    }
                }
            }
        }

        print(arr);


        count(arr);

    }

    public static void count(String[][] arr){
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char a = arr[i][j].charAt(0);
                if(a=='x') return;
                if (Character.isDigit(a)){
                    max = Math.max(max, Integer.parseInt(arr[i][j]));
                }
            }
        }

        Min = Math.min(Min,max);
    }




    public static void copyMap(String[][] copy, String[][] origin ){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = origin[i][j];
            }
        }
    }

    public static void print(String[][] map){
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("=============================");
    }

}
