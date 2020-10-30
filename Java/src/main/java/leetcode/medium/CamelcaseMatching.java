package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        char[] p = pattern.toCharArray();
        List<Boolean> results = new ArrayList();

        for (String query : queries) {
            int idx = 0;
            boolean validQuery = true;
            for (char c : query.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    if (c == p[idx]) {
                        idx += 1;
                    }
                } else {
                    if (c == p[idx]) {
                        idx += 1;
                    } else {
                        validQuery = false;
                        break;
                    }
                }
            }
            results.add(validQuery);
        }
        return results;
    }

}
