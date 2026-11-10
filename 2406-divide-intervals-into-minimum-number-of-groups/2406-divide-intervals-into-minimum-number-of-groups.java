class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> stack = new PriorityQueue<>();

        for(int[] interval : intervals){
            int first = interval[0];
            int end = interval[1];

            if(!stack.isEmpty() && stack.peek() < first){
                stack.poll();
            }

            stack.offer(end);
        }
        return stack.size();
    }
}