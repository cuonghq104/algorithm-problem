package leetcode.easy;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int result = 0;
        while (z > 0) {
            if (z % 2 == 1) result += 1;
            z = z / 2;
        }
        return result;
    }
}
