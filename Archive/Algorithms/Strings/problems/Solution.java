
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Problem Description for 'URLify':
 * Write a method to replace all spaces in a string with '%20'. 
 * You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. 
 * (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * 
 * Constraints:
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consits of lowercase English letters (26 letters)
 * 
 * Questions:
 * are we using ascii?
 * 
 * Observations:
 * We may be able to use an 
 * 
 * Possible Solutions:
 * O(n^2) by comparing each element to every other
 * O(nlogn)
 * O(n)
 * 
 */    
public class Solution {
    public static void main(String[] args)
    {
        Solution s = new Solution();
        /* Solution 1 */
        // valid permutation
        System.out.println(s.canFinish(2, new int[][]{{1,0}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Initalize adjacency list and indegree list of all nodes
        HashMap<Integer, List<Integer>> courses = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int take = prerequisites[i][0], pre = prerequisites[i][1];
            if(!courses.containsKey(take)) courses.put(take, new LinkedList<Integer>());
            courses.put(pre, new LinkedList<Integer>());
            courses.get(pre).add(take);
            indegree.put(take, indegree.getOrDefault(take, 0)+1);
        }
        
        // Step 2: Add all vertices with indegree 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entrySet : indegree.entrySet())
            if(entrySet.getValue() == 0) queue.offer(entrySet.getKey());
        
        // Step 3a: Repeat until queue is empty
        while(!queue.isEmpty()) {
            
            numCourses--;
            
            // Step 3b: A vertex v is removed from the queue
            int course = queue.poll();
            
            // Step 3c: All vertices adjacent to v have their indegrees decremented
            for(int adj : courses.get(course))
            {
                // Step 3d: A vertex is put on the queue as soon as its indegree falls to 0
                indegree.put(adj, indegree.get(adj)-1);
                if(indegree.get(adj) == 0)
                    queue.add(adj);
            }
        }
        
        return numCourses == 0;
    }
}