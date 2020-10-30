package leetcode.stc.waterlevel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point() {

        }
    }

    static int answer;
    static int m, n;
    static int[][] map;
    static int seaLevel;
    static int[][] visited;
    static int head;
    static int tail;

    static Point[] queue;

    static int dx[] = {0, 0, 1, -1, -1, -1, 1, 1};
    static int dy[] = {1, -1, 0, 0, -1, 1, 1, -1};

    static List<Point> list;

//    static int dx[] = {1, 0, -1, 0};
//    static int dy[] = {0, 1, 0, -1};
//

    static void bfs(Point start) {

        visited[start.x][start.y] = 1;
        queue[++tail] = start;
        while (head <= tail) {
            Point pop = queue[head++];
            for (int i = 0; i < 8; i++) {

                int nextx = pop.x + dx[i];
                int nexty = pop.y + dy[i];
                if (nextx >= 1 && nextx <= n && nexty >= 1 && nexty <= m) {
                    if (map[nextx][nexty] > seaLevel && visited[nextx][nexty] == 0) {
                        visited[nextx][nexty] = 1;
                        Point push = new Point();
                        push.x = nextx;
                        push.y = nexty;
                        queue[++tail] = push;
                    }
                }
            }
        }
//        visited[start.x][start.y] = 1;
//        Queue<Point> queue = new LinkedList<>();
//        queue.add(start);
//        while (!queue.isEmpty()) {
//            Point top = queue.poll();
//            visited[top.x][top.y] = 1;
//            for (int i = 0; i < dx.length; i += 1) {
//                int x = top.x + dx[i];
//                int y = top.y + dy[i];
//                if (x >= 1 && x <= n && y >= 1 && y <= m && map[x][y] > 0 && visited[x][y] == 0) {
//                    Point newPoint = new Point();
//                    newPoint.x = x;
//                    newPoint.y = y;
//                    queue.add(newPoint);
//                    visited[x][y] = 1;
//                }
//            }
//        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("D:\\Projects\\Java\\MindX-GD1\\algorithm-problem\\Java\\src\\main\\java\\leetcode\\stc\\waterlevel\\input.txt"));

        int testCase = 1;
        while (true) {
            answer = 0;
            n = sc.nextInt();
            m = sc.nextInt();
            if (n == 0 && m == 0)
                break;
            list = new ArrayList<>();
            map = new int[n + 1][m + 1];
            visited = new int[n + 1][m + 1];
            queue = new Point[40000];

            for (int i = 1; i <= n; i += 1) {
                for (int j = 1; j <= m; j += 1) {
                    map[i][j] = sc.nextInt();
                }
            }

            seaLevel = 1;

            boolean flagDivide = false;
            int low = ~(1 << 31);

            for (int i = 1; i <= m; i++) {
                if (map[1][i] < low)
                    low = map[1][i];
                if (map[n][i] < low)
                    low = map[n][i];
            }

            for (int i = 1; i <= n; i++) {
                if (map[i][1] < low)
                    low = map[i][1];
                if (map[i][m] < low)
                    low = map[i][m];
            }


            for (int i = low; i <= 1000; i++) {
                seaLevel = i;
                Point point = new Point();
                point.x = 1;
                point.y = 1;

                for (int k = 1; k <= n; k++) {
                    for (int l = 1; l <= m; l++) {
                        visited[k][l] = 0;
                        if (map[k][l] > seaLevel) {
                            point.x = k;
                            point.y = l;
                        }
                    }
                }

                head = 0;
                tail = -1;

                bfs(point);

                for (int k = 1; k <= n; k++) {
                    for (int l = 1; l <= m; l++) {
                        if (map[k][l] > seaLevel && visited[k][l] == 0)
                            flagDivide = true;
                    }
                }
                if (flagDivide)
                    break;

            }

            if (flagDivide) {
                // Print the answer to standard output(screen).
                answer = seaLevel;
                System.out.println("Case #" + testCase++ + ": Island splits when ocean rises " + answer + " feet,");
            } else {
                System.out.println("Case #" + testCase++ + ": Island never splits.");
            }
        }
    }
}
