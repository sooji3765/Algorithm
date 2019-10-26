package Practice;

import java.util.*;

public class Dragon {
    public static int[][] d ={{0,1},{-1,0},{0,-1},{1,0}};
    public static int[][] arr= new int[101][101];
    static int G;
    static class Node{
        int x;
        int y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long start = System.currentTimeMillis();

        G = scanner.nextInt();

        for (int i = 0; i < G; i++) {
            LinkedList<Node> list = new LinkedList<>();

            int start_y = scanner.nextInt();
            int start_x = scanner.nextInt();
            int direct = scanner.nextInt();
            int curve = scanner.nextInt();
            list.add(new Node(start_x,start_y,direct));

            list.add(new Node(start_x+d[direct][0],start_y+d[direct][1],(direct<3)?direct+1:0));

            for (int c=1;c<=curve;c++){
                int size = list.size();
                int x = list.get(size-1).x;
                int y = list.get(size-1).y;
                for (int j=size-1;j>=1;j--){

                    int lc = list.get(j).d;
                    list.add(new Node(x+d[lc][0],y+d[lc][1],(lc<3)?lc+1:0));
                    int last = list.size()-1;
                    x = list.get(last).x;
                    y = list.get(last).y;
                }
            }
            for (Node n : list){
                arr[n.x][n.y] = 1;
            }

        }

        int count =0;
        for (int i = 0; i <100 ; i++) {
            for (int j=0;j<100;j++){
                if (arr[i][j]==1){
                    if (arr[i][j+1]==1&&arr[i+1][j+1]==1&&arr[i+1][j]==1){
                        count++;
                    }
                }
            }

        }

        System.out.println(count);
        long end = System.currentTimeMillis();

        System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
    }
}
