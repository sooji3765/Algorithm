package Practice;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3Searching {
    static int N, M,Max=0 ;
    static int[][] copy;
    static int[][] arr;

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1,1,0,0}; // 아래, 위, 왼, 오
    static int[] dy = {0,0,-1,1};
    static LinkedList<Virus> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        queue = new LinkedList<>();
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        copy = new int[N][M];

        for (int i =0; i<N;i++){
            for (int j=0;j<M;j++){
                int input = sc.nextInt();
                copy[i][j] = input;
                if (copy[i][j]==2) queue.add(new Virus(i,j));
            }
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (copy[i][j]==0){
                    copyMap(arr,copy);
                    arr[i][j] =1;
                    makeWall(1);
                    arr[i][j] =0;
                }
            }
        }


        System.out.println(Max);
    }

   public static void makeWall(int cnt){
        if (cnt==3){

            Max = Math.max(Max,bfs());
            return;
        }else{
            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    if (arr[i][j]==0){
                        arr[i][j]=1;
                        makeWall(cnt+1);
                        arr[i][j]=0;
                    }
                }
            }
        }
   }

    public static int bfs(){
        Queue<Virus> q = new LinkedList<>();
        int[][] arr2 = new int[N][M];

        copyMap(arr2,arr);

        for (int i=0;i<queue.size();i++){
            Virus v = queue.get(i);
            q.offer(v);
        }

        while (!q.isEmpty()){
            Virus v = q.poll();
            int x = v.x;
            int y = v.y;

            for (int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if (nx>=0&&nx<N&&ny>=0&&ny<M){
                    if (arr2[nx][ny]==0){
                        arr2[nx][ny] =2;
                        q.offer(new Virus(nx, ny));
                    }
                }
            }
        }

        //print(arr2);

        int cnt =0;
        for (int i=0;i<N;i++){
            for (int j =0;j<M;j++){
                if (arr2[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;

    }


    public static void print(int[][] arr){
        for (int i=0;i<N;i++){
            for (int j =0;j<M;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }

    public static void copyMap(int[][] arr, int[][] arr2){
        for (int i =0;i<N;i++){
            for (int j=0;j<M;j++){
                arr[i][j]= arr2[i][j];
            }
        }
    }
}
