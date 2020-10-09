import java.util.*;

class QuickSort {
    private int findNextFirstAvailableCourse(int n, Set<Integer> set) {
        for (int i = 0; i < n; i += 1) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] aList = new List[numCourses];
        for (int i = 0; i < prerequisites.length; i += 1) {
            int a = prerequisites[i][1];
            int b = prerequisites[i][0];

            if (aList[b] == null) {
                aList[b] = new ArrayList<>();
            }

            aList[b].add(a);
        }

        Set<Integer> checked = new HashSet<Integer>();
        Stack<Integer> stack = new Stack();
        Set<Integer> waiting = new HashSet<Integer>();

        int t = findNextFirstAvailableCourse(numCourses, checked);
        while(t != -1) {
            stack.push(t);
            waiting.add(t);

            while(!stack.isEmpty()) {
                int top = stack.pop();
                checked.add(top);
                waiting.remove(top);

                if (aList[top] != null) {
                    for (Integer i : aList[top]) {
                        if (waiting.contains(i)) {
                            return false;
                        }

                        if (!checked.contains(i)) {

                            stack.push(top);
                            waiting.add(top);
                            stack.push(i);
                            waiting.add(i);

                            break;
                        }
                    }
                }
            }

            t = findNextFirstAvailableCourse(numCourses, checked);
        }
        return true;
    }

    private static void printList(LinkedList<String> linkedList)
    {
        Iterator<String> i = linkedList.iterator();

        while(i.hasNext())
        {
            System.out.println(i.next());
        }

        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Abc");
        list.add("xyz");
        list.add("abu");
        printList(list);
    }
}

