package Practice;

import java.util.Scanner;

public class StartLink {
    public static int N,Min= Integer.MAX_VALUE;
    public static int[][] map;
    public static boolean[] visited;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, N/2);

        System.out.println(Min);
        long end = System.currentTimeMillis();
        System.out.println((int)start-end/1000.0);
    }

    private static void dfs(int index, int n) {
        if (index==n){
            cal();
        }

        for (int i =index;i<N;i++){
            if (!visited[i]){
                visited[i]=true;
                dfs(index+1,n);
                visited[i]=false;
            }
        }
    }

    public static void cal(){
        int[] star = new int[N/2];
        int[] link = new int[N/2];

        int s =0;
        int l =0;
        for (int i = 0; i < N; i++) {
            if (visited[i]){
                star[s++] = i;
            }else {
                link[l++] = i;
            }
        }

        int sState = getCount(star);
        int aState = getCount(link);

        int result = Math.abs(sState-aState);
        Min= Math.min(Min,result);
    }
    public static int getCount(int[] a){
        int result =0;
        for (int i = 0; i <N/2 ; i++) {
            for (int j = i+1; j <N/2 ; j++) {
                result+=map[a[i]][a[j]]+map[a[j]][a[i]];
            }
        }
        return result;
    }


}
