package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    int n;
    List<String> results;
    int[] parenthesis;

    private void addResult() {
        StringBuilder mBuilder = new StringBuilder("");
        for (int i : parenthesis) {
            mBuilder.append((i == 1) ? "(" : ")");
        }
        results.add(mBuilder.toString());
    }

    private void generate(int next, int totalOne, Stack<Integer> stack) {
        if (next == n * 2)
            return;

        if (totalOne == n) {
            Arrays.fill(parenthesis, next, 2 * n - 1, 0);
            addResult();
            return;
        }

        stack.push(1);
        parenthesis[next] = 1;
        generate(next + 1, totalOne + 1, stack);
        stack.pop();

        if (!stack.isEmpty()) {
            stack.pop();
            parenthesis[next] = 0;
            generate(next + 1, totalOne, stack);
            stack.push(1);
        }
    }

    public List<String> generateParenthesis(int n) {
        Stack<Integer> parenthesisStack = new Stack<>();

        results = new ArrayList<>();
        this.n = n;

        parenthesis = new int[n * 2];
        Arrays.fill(parenthesis, 0);

        if (n == 0)
            return results;

        parenthesis[0] = 1;
        parenthesisStack.push(1);
        generate(1, 1, parenthesisStack);

        return results;
    }

    public static void main(String[] args) {
        GenerateParentheses mParentheses = new GenerateParentheses();
        mParentheses.generateParenthesis(3);
    }
}
