package leetcode.medium;

import java.util.PriorityQueue;

class TwoCityScheduling {

    class Item implements Comparable<Item> {
        int key;
        int index;

        Item(int key, int index) {
            this.key = key;
            this.index = index;
        }

        @Override
        public int compareTo(Item o) {
            return (this.key - o.key);
        }

    }

    public int twoCitySchedCost(int[][] costs) {
        int length = costs.length;
        int[] group = new int[length];
        int aGroup = 0;
        int bGroup = 0;

        for (int i = 0; i < length; i += 1) {
            if (costs[i][0] > costs[i][1]) {
                group[i] = 2;
                bGroup += 1;
            } else {
                group[i] = 1;
                aGroup += 1;
            }
        }
        PriorityQueue<Item> items = new PriorityQueue<>();
        if (aGroup > bGroup) {

            for (int i = 0; i < length; i += 1) {
                if (group[i] == 1) {
                    items.add(new Item(costs[i][1] - costs[i][0], i));
                }
            }
            for (int i = 0; i < (aGroup - bGroup) / 2; i += 1) {
                Item item = items.poll();
                group[item.index] = 2;
            }
        } else if (aGroup < bGroup) {

            for (int i = 0; i < length; i += 1) {
                if (group[i] == 2) {
                    items.add(new Item(costs[i][0] - costs[i][1], i));
                }
            }
            for (int i = 0; i < (bGroup - aGroup) / 2; i += 1) {
                Item item = items.poll();
                group[item.index] = 1;
            }
        }
        int result = 0;
        for (int i = 0; i < length; i += 1) {
            result += (group[i] == 1) ? costs[i][0] : costs[i][1];
        }
        return result;
    }

    public static void main(String[] args) {
        TwoCityScheduling mScheduling = new TwoCityScheduling();
        mScheduling.twoCitySchedCost(new int[][]{
                new int[]{518, 518},
                new int[]{71, 971},
                new int[]{121, 862},
                new int[]{967, 607},
                new int[]{138, 754},
                new int[]{513, 337},
                new int[]{499, 873},
                new int[]{337, 387},
                new int[]{647, 917},
                new int[]{76, 417}
        });
    }
}


