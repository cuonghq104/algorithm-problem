package leetcode.medium;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Permutation {

    class Dummy {
        String name;
        String type;
        String direction;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }
    }

    public static void main(String[] args) {
        int m = 0;
        int pass = 0;
        int credit = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    for (int l = 0; l < 101; l++) {
                        m++;
                        float finalGrade = (float) (i * 0.1 + j * 0.15 + k * 0.15 + l * 0.6);
                        if (finalGrade >= 50 && finalGrade < 60) {
                            pass += 1;
                        } else if (finalGrade >= 60 && finalGrade < 70) {
                            credit += 1;
                        }
                    }
                }
            }
        }
        System.out.println(m);
        System.out.println(pass);
        System.out.println(credit);
        //out: 134431
    }

//    public static void main(String[] args) {
//        List<Integer>[] ums = new List[10];
//        System.out.println("Enter limit");
//        Scanner sc = new Scanner(System.in);
//        int limit = sc.nextInt();
//        int n2 = 1, i = 1;
//
//        while(n2<=limit){
//            System.out.print(n2+" ");
//            n2=n2+i*i;
//            i++;
//        }
//    }

    public int[][] merge(int[][] interval) {
        Arrays.sort(interval, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> results = new ArrayList<>();
        int index = 0;
        while (index + 1 < interval.length) {
            if (interval[index][1] > interval[index + 1][0]) {
                interval[index + 1][0] = interval[index][0];
                interval[index + 1][1] = Math.max(interval[index][1], interval[index + 1][1]);
            } else {
                results.add(interval[index]);
            }
            index += 1;
        }

        results.add(interval[interval.length - 1]);
        return new int[0][];
    }


    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> results = new ArrayList<>();
        int iA = 0;
        int iB = 0;

        int[][] a = new int[][] {new int[] {1, 2}, new int[] {10, 12}, new int[] {4, 6}};
        Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(a);
        while (iA < A.length && iB < B.length) {
            while (iA < A.length && A[iA][1] < B[iB][0]) {
                iA += 1;
            }
            if (iA == A.length)
                break;

            while (iB < B.length && B[iB][1] < A[iA][0]) {
                iB += 1;
            }
            if (iB == B.length)
                break;

            int la = A[iA][0];
            int lb = B[iB][0];
            int ra = A[iA][1];
            int rb = B[iB][1];

            if (la <= lb && ra >= rb) {
                results.add(B[iB]);
                iB += 1;
            } else if (la < lb && ra >= lb && ra <= rb) {
                results.add(new int[]{lb, ra});
                iA += 1;
            } else if (la >= lb && ra <= rb) {
                results.add(A[iA]);
                iA += 1;
            } else if (lb < la && rb >= la && rb <= ra) {
                results.add(new int[]{la, rb});
                iB += 1;
            }

        }

        return results.size() == 0 ? new int[0][] : results.toArray(new int[][]{new int[0]});
    }

}
